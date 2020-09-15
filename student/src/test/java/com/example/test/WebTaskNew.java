package com.example.test;


import lombok.Data;

import java.io.Serializable;

/**
 * Created by Joey
 * Desc: app端返回的新手任务model
 * Date: 2017/2/11
 * Version: 1.0
 */
@Data
public class WebTaskNew implements Serializable {

    private static final long serialVersionUID = 2241498161875180861L;

    private int taskId;

    private String title;

    private String desc;

    private int credit;

    private int gold;

    private String goldDesc;

    private int state;

    private int priority;

    private boolean userWeixinCashout;
    private String userWeixinHint;
    private int userWeixinGoldLimit;
    private int userWeixinGoldTotal;
    private int userWeixinRMB;
    private boolean excludeMaster;
    private long countDown;

    private String stateDesc;

    private String type;


    private int h5;
    private String h5Hint;
    private String h5ActionText;
    private String h5Jump;
    private String h5Icon;
    //0是金币 1是砖石
    private int h5IconSmall;
    private String extra;
    private Integer autoGain;
    //任务完成次数 0:每日完成一次 1:一个账号只能完成一次 2:一直展示 3一天可多次完成
    private Integer timeType;
    //需要完成的次数
    private Integer times;
    private Integer position;

    public static WebTaskNew build(TaskDailyPlanEntity taskPlan) {
        WebTaskNew webTaskNew = new WebTaskNew();
        webTaskNew.setTaskId(taskPlan.getId());
        webTaskNew.setH5(taskPlan.getState());
        webTaskNew.setTitle(taskPlan.getTitle());
        webTaskNew.setDesc(taskPlan.getDescription());
        webTaskNew.setH5Jump(taskPlan.getH5Jump());
        webTaskNew.setH5Hint(taskPlan.getH5Hint());
        webTaskNew.setH5Icon(taskPlan.getH5Icon());
        webTaskNew.setH5ActionText(taskPlan.getH5ActionText());
        webTaskNew.setH5IconSmall(taskPlan.getH5IconSmall());
        webTaskNew.setCredit(taskPlan.getCredit());
        webTaskNew.setType(taskPlan.getCreditType() + "" + taskPlan.getCreditSubType());
        webTaskNew.setGold(taskPlan.getGold());
        webTaskNew.setState(taskPlan.getState());
        webTaskNew.setExtra(taskPlan.getExtra());
        webTaskNew.setPriority(taskPlan.getPriority());//任务优先级
        webTaskNew.setAutoGain(taskPlan.getAutoGain());
        webTaskNew.setTimeType(taskPlan.getTimesType());
        webTaskNew.setTimes(taskPlan.getTimes());
        webTaskNew.setPosition(Integer.valueOf(taskPlan.getPosition()));
        return webTaskNew;
    }
}
