package com.example.designPattern23.singleton;

/**
 * @description: EnumSingleton2
 * @date: 2020/7/7 下午9:14
 * @author: zcy
 * @version: 1.0
 */
public enum EnumSingleton2 {
    INSTANCE;
    private TestSingleton testSingleton;

    EnumSingleton2(){
        this.testSingleton = new TestSingleton();
    }
    public TestSingleton getTestSingleton(){
        return this.testSingleton;
    }
}

class TestSingleton{
    public static void main(String[] args) {
        TestSingleton testSingleton = EnumSingleton2.INSTANCE.getTestSingleton();
        TestSingleton testSingleton1 = EnumSingleton2.INSTANCE.getTestSingleton();
        TestSingleton testSingleton2 = EnumSingleton2.INSTANCE.getTestSingleton();
    }
}
