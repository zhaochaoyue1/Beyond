package com.example.test;

/**
 * @author liujinkun
 * @Title: GoldEnum
 * @Description: 幸运星枚举
 * @date 2019/9/3 10:01 PM
 */
public enum HashRateEnum {
    /**
     * 不需要的
     */
    DEFAULT(0,0,"未知"),
    BOUND_WECHAT(2, 4, "任务奖励"),
    TASK_FILL_INVITE_REWARD(2,5,"任务奖励"),
    TASK_WITHDRAW(2,6,"任务奖励"),
    TASK_SCRAPING_CARD(2,7,"任务奖励"),
    TASK_START_SIGN(2,8,"任务奖励"),
    TASK_ZHIKE_ADVERTISING(2,9,"任务奖励"),
    TASK_INVITER_FRIEND(2,10,"邀请奖励"),
    TASK_LOOK_VIDEO(2,11,"任务奖励"),
    TASK_COMPOUND_PET(2,12,"任务奖励"),
    TASK_PET_UPGRADE(2,13,"任务奖励"),
    TASK_UNLOCK_TEN_PET(2,14,"任务奖励"),
    TASK_UNLOCK_TWENTY_PET(2,15,"任务奖励"),
    TASK_UNLOCK_THIRTY_PET(2,16,"任务奖励"),
    TASK_SIGN(2,17,"每日签到"),
    INVITER_DISCIPLE(2,18,"邀请奖励"),
    RATE_TICKET(2,19,"兑换消耗"),
    RATE_BACK(2,21,"订单失败幸运星退回"),
    //广告中台订单奖励积分类型（其他类型积分不能定义成为该类型只为回调使用
    AD_CENTER_REWARD(10, 3, "广告奖励"),
    //开启任务权限
    START_JURISDICTION(2,23,"任务奖励"),
    //转盘获取
    RATE_TURN_TABLE(2,24,"转盘获取"),
    //红星提现扣除
    RED_WITHDRAW(2,25,"提现扣除"),

    /*---------------------------师徒进贡奖励------------------*/
    ACCEPT_PRENTICE_AWARD(3,1,"收徒奖励"),
    ACCEPT_DISCIPLE_AWARD(3,2,"徒孙奖励"),
    PRENTICE_ACTIVE_AWARD(3,3,"徒弟活跃"),
    DISCIPLE_ACTIVE_AWARD(3,4,"徒孙活跃");
    // 父类型
    private int type;
    // 子类型
    private int subType;
    // 描述
    private String desc;

    HashRateEnum(int type, int subType, String desc) {
        this.type = type;
        this.subType = subType;
        this.desc = desc;
    }

    public int type() {
        return type;
    }

    public int subType() {
        return subType;
    }

    public String desc() {
        return desc;
    }

    public static HashRateEnum get(int type, int subType) {
        for (HashRateEnum model : HashRateEnum.values()) {
            if (model.type == type && model.subType == subType) {
                return model;
            }
        }
        return HashRateEnum.DEFAULT;
    }
}
