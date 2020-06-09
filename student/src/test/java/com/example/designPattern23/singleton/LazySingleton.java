package com.example.designPattern23.singleton;

/**
 * description: LazySingleton 懒加载又称懒汉式 但是不能避免反序列化，可以用spring的bean工厂解决
 * date: 2020/5/30 下午7:46
 * author: zcy
 * version: 1.0
 */
public class LazySingleton {
    //防止指令重排
    private static volatile LazySingleton lazySingleton;

    /**
     * 用private修饰符修饰构造器，new 方法只能在本类中使用
     */
    private LazySingleton() {

    }

    /**
     * 获取对象的方法
     *
     * @return
     */
    public static LazySingleton getInstance() {
        //双检查
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}
