package com.example;

import com.alibaba.fastjson.JSONObject;
import com.example.test.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

/**
 * @description: Test2
 * @date: 2020/8/15 下午12:26
 * @author: zcy
 * @version: 1.0
 */
public class Test2 {
    private static volatile List<TaskDailyPlanEntity> taskDailyList = Lists.newArrayList();
    private static volatile Map<Integer, TaskDailyPlanEntity> taskDailyPlanIdMap = Maps.newConcurrentMap();
    private static volatile Map<HashRateEnum, TaskDailyPlanEntity> enumTaskDailyMap = Maps.newConcurrentMap();


    private static final int PET_MAX_GRADE = 38;

    @Value("${isEvn:false}")
    private static boolean isEvn = false;
    private static final String HTTPS_URL = "http://bp-api.coohua.top/ad/service/conf/queryAdConfListG1?appId=%d";
    private static final OkHttpClient okHttpClient = new OkHttpClient();

    //初始化查询任务
    public static void updateTaskNewPlanList() {

        //查询线上所有任务
        List<TaskDailyPlanEntity> latestValidTaskList = Lists.newArrayList();
        String url = null;
        //正式
        if (isEvn) {
            //url = String.format(HTTPS_URL, ProjectConstants.APP_ID);
        } else {
            //测试
            url = String.format(HTTPS_URL, 19);
        }
        Request build = new Request.Builder().url(url).build();
        String response = null;
        try {
            response = okHttpClient.newCall(build).execute().body().string();
        } catch (IOException e) {
        }
        if(StringUtils.isNotEmpty(response)){
            JSONObject jsonObject = JSONObject.parseObject(response);
            if(jsonObject.getIntValue("code")!=200){
            }
            String result = jsonObject.getString("result");
            if(StringUtils.isNotEmpty(result)){
                List<TaskDailyPlanEntity> taskDailyPlanEntities = JSONObject.parseArray(result, TaskDailyPlanEntity.class);
                if(!CollectionUtils.isEmpty(taskDailyPlanEntities)){
                    latestValidTaskList.addAll(taskDailyPlanEntities);
                }
            }
        }
        System.out.println(JSONObject.toJSONString(latestValidTaskList));
        if (!CollectionUtils.isEmpty(latestValidTaskList)) {
            Map<Integer, TaskDailyPlanEntity> latestTaskDailyPlanIdMap = Maps.newConcurrentMap();
            Map<HashRateEnum, TaskDailyPlanEntity> enumTaskDaily = Maps.newConcurrentMap();
            for (TaskDailyPlanEntity taskPlan : latestValidTaskList) {
                latestTaskDailyPlanIdMap.put(taskPlan.getId(), taskPlan);
                enumTaskDaily.put(HashRateEnum.get(taskPlan.getCreditType(), taskPlan.getCreditSubType()), taskPlan);
            }
            taskDailyList = latestValidTaskList;
            taskDailyPlanIdMap = latestTaskDailyPlanIdMap;
            enumTaskDailyMap = enumTaskDaily;
        }
    }

    public static JSONObject getDailyTaskList(UserInfo userInfo) {
        JSONObject jsonObject = new JSONObject();
        List<WebTaskNew> result = Lists.newArrayList();
        List<WebTaskNew> recommend = Lists.newArrayList();
        if (CollectionUtils.isEmpty(taskDailyList)) {
            return jsonObject;
        }
        for (TaskDailyPlanEntity taskDailyPlanEntity : taskDailyList) {
            WebTaskNew webTaskNew = getTaskList(taskDailyPlanEntity, userInfo);
            if (webTaskNew != null) {
                if (webTaskNew.getPosition() == 1) {
                    result.add(webTaskNew);
                } else {
                    recommend.add(webTaskNew);
                }
            }
        }
        jsonObject.put("dailyTask", result);
        jsonObject.put("recommendTask", recommend);
        return jsonObject;
    }

    private static WebTaskNew getTaskList(TaskDailyPlanEntity taskDailyPlanEntity, UserInfo userInfo) {
        long userId = userInfo.getUserId();
        if (!taskDailyPlanEntity.isEffect(userId, userInfo.getAppVersion(), userInfo.getOs() == OsEnum.IOS.code(), userInfo.getIsRestricted(), new Date(userInfo.getCreateTime()))) {
            return null;
        }
        HashRateEnum hashRateEnum = HashRateEnum.get(taskDailyPlanEntity.getCreditType(), taskDailyPlanEntity.getCreditSubType());

        WebTaskNew webTaskNew = WebTaskNew.build(taskDailyPlanEntity);
        //1判读任务是否完成
        if (!isFinishState(userId, taskDailyPlanEntity)) {
            webTaskNew.setState(0);
            return webTaskNew;
        }
        return null;
    }
    private static boolean isFinishState(long userId, TaskDailyPlanEntity taskDailyPlanEntity) {
        Integer taskId = taskDailyPlanEntity.getId();
        int timesType = taskDailyPlanEntity.getTimesType();
        if (timesType == TaskTimesType.DAILY_ONE.id) {
            //每日完成一次
            return false;
        }
        return true;
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        /*HashMap<Object, Object> map = Maps.newHashMap();
        for (int i = 0; i < 13; i++) {
            map.put(i,i);
        }
        System.out.println();*/
        byte[] encode = Base64.getEncoder().encode("http://www.baidu.com".getBytes());
        String baidu = new String(encode);
        System.out.println(baidu);
        byte[] decode1 = Base64.getUrlDecoder().decode(baidu);
        System.out.println(new String(decode1));
        String s = "aHR0cHMlM0EvL3NoYXJlLWZpbGUtY2RuLnRlemlnbi5jb20vdXNlci8ucHJldmlldy9tbHd3b2M0b2wvOTI2ZmNmNzFlYzJjM2U4YTdmMDUwYzAzMDQ3YjhjMDAubXA0L21wNC85MjZmY2Y3MWVjMmMzZThhN2YwNTBjMDMwNDdiOGMwMF8xMjgwUC5tcDQlM0ZhdXRoX2tleSUzRDE2NTgyNDY0MDAtMC0wLTczZjc1Mzc5ZGFlZTVkM2I1MTMyMWJkYjg1YzhlODU5";
        byte[] decode = Base64.getUrlDecoder().decode(s);
        System.out.println(new String(Base64.getDecoder().decode(s.getBytes())));
        System.out.println(new String(decode,"utf-8"));
        byte[] decode2 = Base64Utils.decode(s.getBytes());
        System.out.println(URLDecoder.decode(new String(decode2),"UTF-8"));


        //"https://share-file-cdn.tezign.com/user/.preview/mlwwoc4ol/926fcf71ec2c3e8a7f050c03047b8c00.mp4/mp4/926fcf71ec2c3e8a7f050c03047b8c00_1280P.mp4?Fauth_key=1658246400-0-0-73f75379daee5d3b51321bdb85c8e859";
    }
}
