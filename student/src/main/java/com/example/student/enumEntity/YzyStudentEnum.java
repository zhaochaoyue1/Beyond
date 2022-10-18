package com.example.student.enumEntity;

/**
 * @description: YzyStudentEnum
 * @date: 2022/7/18 下午11:11
 * @author: zcy
 * @version: 1.0
 */
public enum YzyStudentEnum {
    //快速揽客签到
    LANGUAGE(1,"语文","这是语文",true,false)
    ,MATH(2,"数学","这是数学",true)
    ,ENGLISH(3,"英语","这是英语",false)
    ;

    private Integer id;

    private String field;

    private String desc;

    /**
     * 是否需要学习
     */
    private boolean isNeedBool;

    /**
     * 是否喜爱
     */
    private boolean isLike =true;

    YzyStudentEnum(Integer id, String field, String desc, boolean isNeedBool, boolean isLike) {
        this.id = id;
        this.field = field;
        this.desc = desc;
        this.isNeedBool = isNeedBool;
        this.isLike = isLike;
    }

    YzyStudentEnum(Integer id, String field, String desc, boolean isNeedBool) {
        this.id = id;
        this.field = field;
        this.desc = desc;
        this.isNeedBool = isNeedBool;
    }

    public static YzyStudentEnum getStudentEnum(Integer id){
        for (YzyStudentEnum studentEnum:YzyStudentEnum.values()){
            if(studentEnum.id.equals(id)){
                return studentEnum;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        //传入的值
        Integer id = 1;
        //查询到的枚举，枚举类有具体的信息
        YzyStudentEnum studentEnum = YzyStudentEnum.getStudentEnum(id);
        if(studentEnum!=null&&studentEnum.isNeedBool){
            System.out.println(studentEnum.desc+"是我想学的"+(studentEnum.isLike?"喜爱":"不喜爱"));
        }
    }
}
