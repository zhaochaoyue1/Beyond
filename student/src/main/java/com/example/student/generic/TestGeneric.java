package com.example.student.generic;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *
 * https://www.cnblogs.com/coprince/p/8603492.html
 * @description: TestGeneric
 * @date: 2023/1/6 下午4:39
 * @author: zcy
 * @version: 1.0
 */
public class TestGeneric {

    public static <T> void printMsg(T... args){
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }

    public static void showKey(Generic<? extends Number> object){
        System.out.println("泛型测试key value is " + object.getKey());
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        //printMsg("112",1,"3");
       //Generic<String> stringGeneric = new Generic<>("111");
        Generic<Integer> integerGeneric = new Generic<>(111);
        Generic<Float> generic3 = new Generic<Float>(2.4f);
        Generic<Double> generic4 = new Generic<Double>(2.56);
        //showKey(stringGeneric);
        //showKey(integerGeneric);
    }
}

class Generic<T extends Number>{
    private T key;
    public Generic(T t){
        this.key = t;
    }
    public T getKey(){
        return key;
    }
}
