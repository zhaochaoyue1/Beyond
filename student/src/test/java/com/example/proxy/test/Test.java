package com.example.proxy.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: Test
 * @date: 2020/6/19 下午4:42
 * @author: zcy
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        //静态代理
        //TargetStatic targetStatic = new TargetStatic(new Target());
        //targetStatic.find();

        //动态代理
        /*TargetInterface target = new Target();
        TargetInterface proxyInstance = (TargetInterface)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, arg) -> {
                    System.out.println("方法调用前");
                    method.invoke(target, args);
                    System.out.println("方法调用后");
                    return proxy;
                });
        proxyInstance.find();*/

        //cglib代理
        TargetCglib targetCglib = new TargetCglib();
        TargetCglibEntity object = (TargetCglibEntity)targetCglib.getObject(new TargetCglibEntity());
        object.find();
    }
}

class TargetCglibEntity{
    public void find(){
        System.out.println("这是一个查询方法");
    }
}

class TargetCglib implements MethodInterceptor {
    private Object object;

    public Object getObject(Object object){
        this.object = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用方法之前");
        Object invoke = method.invoke(object, objects);
        System.out.println("调用方法之后");
        return invoke;
    }
}


class Target implements TargetInterface {
    @Override
    public void find() {
        System.out.println("这是个查询方法");
    }
}

interface TargetInterface {
    void find();
}

class TargetStatic implements TargetInterface {
    private TargetInterface targetInterface;

    public TargetStatic(TargetInterface targetInterface) {
        this.targetInterface = targetInterface;
    }

    @Override
    public void find() {
        System.out.println("方法执行之前");
        targetInterface.find();
        System.out.println("方法执行之后");
    }
}
