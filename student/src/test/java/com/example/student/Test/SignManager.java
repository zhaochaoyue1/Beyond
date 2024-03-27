package com.example.student.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.student.util.DateTimeUtils;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

import java.util.Date;


@Slf4j
@Component
public class SignManager {

    private static final int INTERVAL = 59;

   static ThreadLocal<SignModel> threadLocal = new ThreadLocal<>();

    /**
     * 根据毫秒数获取 从计算机 日历到今天的 天数
     *
     * @param mill
     * @return
     */
    public static Integer getSimpleDay(Long mill) {
        return ((Long) ((mill + 1000 * 60 * 60 * 8) / DateUtils.MILLIS_PER_DAY)).intValue();
    }

    /**
     * 重置签到
     */
    public static SignModel resetSign(SignModel signModel,long curTime){
        Integer curDay = getSimpleDay(curTime);
        if(signModel == null){
            signModel = new SignModel();
            signModel.setCount(0);
            signModel.setStatus(0L);
            signModel.setFromDate(curDay-INTERVAL);
            return signModel;
        }
        Integer beginDay = signModel.getFromDate();
        int sub = curDay - beginDay - INTERVAL;
        if(sub > 0 && sub <= INTERVAL){
            Long status = signModel.getStatus();
            String binaryString = Long.toBinaryString(status);
            int move  = Math.max(0,sub-(64-binaryString.length()));
            String substring = binaryString.substring(0, move);
            int sum = 0;
            for (int i = 0; i < move; i++) {
                if(substring.charAt(i)=='1'){
                    sum++;
                }
            }
            signModel.setFromDate(signModel.getFromDate()+sub);
            signModel.setStatus(status<<sub);
            signModel.setCount(signModel.getCount()+sum);
        }else if(sub >= INTERVAL){
            signModel.setCount(0);
            signModel.setStatus(0L);
            signModel.setFromDate(curDay-INTERVAL);
        }
        return signModel;
    }

    /**
     * 获取签到详情
     */
    public static  SignModel getSignModel(String value,long curTime){
        if(StringUtils.isEmpty(value)){
            return resetSign(null,curTime);
        }else {
            return resetSign(JSONObject.parseObject(value, SignModel.class),curTime);
        }
    }

    /**
     * 今日是否签到
     */
    public static boolean isSign(String value,long curTime){
        SignModel sign = getSignModel(value,curTime);
        String binaryString = Long.toBinaryString(sign.getStatus());
        if(binaryString.length() < 5){
            return false;
        }else if(binaryString.charAt(binaryString.length()-5) == '1'){
            return true;
        }
        return false;
    }

    /**
     * 指定日期签到
     */
    public static boolean isSign(String value,long curTime,long specified){
        SignModel signModel = getSignModel(value, curTime);
        Integer simpleDay = getSimpleDay(specified);
        int index = simpleDay - signModel.getFromDate();
        String binaryString = Long.toBinaryString(signModel.getStatus());
        if(index>=0 && index < binaryString.length()){
            if(binaryString.charAt(index) == '1'){
                return true;
            }
        }
        return false;
    }

    /**
     * 指定日期签到
     */
    public static boolean sign(String value,long curTime,long specified){
        SignModel signModel = getSignModel(value, curTime);
        Integer simpleDay = getSimpleDay(specified);
        if(isSign(value,curTime,specified)){
            return false;
        }
        int index = simpleDay - signModel.getFromDate();
        if(index>=0 && index<=INTERVAL){
            signModel.setStatus(signModel.getStatus() | (1L << (63-index)));
            System.out.println("补签成功："+JSONObject.toJSONString(signModel));
            return true;
        }
        return false;
    }

    /**
     * 签到今天
     */
    public static boolean sign(String value,long curTime){
        SignModel signModel = getSignModel(value,curTime);
        signModel.setStatus(signModel.getStatus() | 1 << 4);
        System.out.println("签到成功："+ JSONObject.toJSONString(signModel));
        threadLocal.set(signModel);
        return true;
    }

    /**
     * 已经签到多少天
     */
    public static int getDays(){
        SignModel signModel = threadLocal.get();
        Long status = signModel.getStatus();
        int day = 0;
        String binaryString = Long.toBinaryString(status);
        int len = binaryString.length() - 5;
        for (int i =  len; i >= 0; i--) {
            if(binaryString.charAt(i) == '1'){
                day++;
                continue;
            }
            if(len == i){
                continue;
            }
            break;
        }
        return day+signModel.getCount();
    }

    public static void signDetail(){
        SignModel signModel = threadLocal.get();
        signModel = resetSign(signModel, System.currentTimeMillis());
        String binaryString = Long.toBinaryString(signModel.getStatus());
        int len = binaryString.length() - 5;
        for (int i = len,day=0; i >= 0 ; i--) {
            boolean sign = false;
            if(binaryString.charAt(i) == '1'){
                sign = true;
            }
            System.out.println(DateTimeUtils.formatYYYYMMDD(DateTimeUtils.addDays(new Date(),-day++))+"   " + sign);
        }
    }


    public static void main(String[] args) {
        //String value = null;
        String value = "{\"count\":1,\"fromDate\":19687,\"status\":32}";
        long curTime = System.currentTimeMillis();
        SignModel signModel = getSignModel(value, curTime);
        System.out.println(JSONObject.toJSONString(signModel));
        if(isSign(value,curTime)){
            return;
        }
        sign(value,curTime);
        SignModel signModel1 = threadLocal.get();
        /*String countSign = "2024-01-23";
        long specified = DateTimeUtils.parseYYYYMMDD(countSign).getTime();
         value = JSONObject.toJSONString(signModel1);
        if(isSign(value,curTime,specified)){
            return;
        }
        sign(value,curTime,specified);*/
        System.out.println(getDays());
        signDetail();
        threadLocal.remove();
    }
}
