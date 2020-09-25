package com.example.classloader;

/**
 * @description: ClassLoaderDescription
 * @date: 2020/9/23 下午9:40
 * @author: zcy
 * @version: 1.0
 */
public class ClassLoaderDescription {
    /**
     * 加载：将类的class文件读入内存，并创建java.lang.Class等
     *
     *      | ------    验证：文件格式、语法语义验证等
     * 链接  |--------   准备：为static修改的静态域做默认初始化，并在方法区分配空间
     *      |--------   解析： 将符号引用替换为直接应用
     *
     *
     *  初始化： 1、创建类的实例 2、访问类或者接口的静态变量 3、调用静态方法 4、反射 5、初始化类的子类 6、Java虚拟机启动时被标明为启动类
     */
    public static void main(String[] args) {

    }
}
