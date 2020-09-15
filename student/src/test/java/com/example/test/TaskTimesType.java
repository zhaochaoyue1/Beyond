package com.example.test;

/**
 * Created by mengweibo on 2018/11/14.
 */
public enum TaskTimesType {
    /**
     * 任务完成次数
     */
    DAILY_ONE(0, "每日完成一次"),
    ONE(1, "一个账号只能完成一次"),
    PERMANENT(2, "一直展示"),
    MANY_TIMES(3, "可多次完成");

    public final int id;
    public final String desc;

    TaskTimesType(int mark, String desc) {
        this.id = mark;
        this.desc = desc;
    }

}
