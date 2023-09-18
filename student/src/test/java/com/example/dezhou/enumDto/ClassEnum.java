package com.example.dezhou.enumDto;

/**
 * @description: ClassEnum
 * @date: 2023/9/8 下午4:28
 * @author: zcy
 * @version: 1.0
 */
public enum  ClassEnum {
    ABANDON_CAR(-1,"放弃"),
    HIGN(1,"高"),
    ONE(2,"一对"),
    TWO(3,"两对"),
    THREE(4,"三条"),
    SHUNZI(5,"顺子"),
    TONGHUA(6,"同花"),
    HULU(7,"葫芦"),
    FOUR(8,"四条"),
    tonghuaShun(9,"同花顺");

    private int type;
    private String desc;

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    ClassEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    private static ClassEnum getClassEnum(int type){
        for (ClassEnum classEnum:ClassEnum.values()){
            if(type == classEnum.getType()){
                return classEnum;
            }
        }
        return null;
    }
}
