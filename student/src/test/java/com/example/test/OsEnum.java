package com.example.test;

/**
 * @author liujinkun
 * @Title: OsEnum
 * @Description: 系统枚举
 * @date 2019/9/5 9:49 PM
 */
public enum OsEnum {

    ANDROID(0,"android"),

    IOS(1,"ios");

    private int code;

    private String desc;

    OsEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int code() {
        return this.code;
    }

    public String desc() {
        return this.desc;
    }
}
