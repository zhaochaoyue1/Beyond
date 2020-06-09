package com.example.designPattern23.singleton;

import com.example.student.Student;
import com.example.student.project.domain.User;

/**
 * description: EnumSingleton 枚举单例
 * 不仅可以解决线程同步，还可以防止反序列化
 * date: 2020/5/30 下午8:11
 * author: zcy
 * version: 1.0
 */
public class EnumSingleton {
    private EnumSingleton(){

    }
    static enum Singleton {
        INSTANCE;
        private EnumSingleton enumSingleton;

        Singleton() {
            enumSingleton = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return enumSingleton;
        }
    }

    public static EnumSingleton getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(EnumSingleton.getInstance());
            }).start();
        }
    }
}
