package com.example.designPattern23.chainOfResponsibility.servlet;

/**
 * @description: ServletMain 责任链模式：责任链是一种设计模式，在责任链里，很多对象由每一个对象对其下家的引用
 * 而连接起来形成一条链。请求在这个链上传递，直到链上的某一个对象决定处理此请求。发出这个请求的客户端并不知道链上的
 * 哪一个对象最终处理这个请求，这使得系统可以在不影响客户端的情况下动态地重新组织和分配责任。
 *
 * 个人总结：责任链实现方式，多态；定义一个父类接口且定义一个责任链的执行方法，所有链上的对象实现父类的接口和方法，再定一个存储实现类的对象（父类应用指向子类）
 * ，在这个存储对象遍历或递归List;
 * @date: 2020/6/13 下午4:11
 * @author: zcy
 * @version: 1.0
 */
public class ServletMain {
    public static void main(String[] args) {
        Request request = new Request();
        request.setStr("他妈的，996，666");
        Response response = new Response();
        response.getStr().append("response:");

        FilterChain filterChain = new FilterChain();
        filterChain.add(new ChinaServletFilter()).add(new NumServletFilter());
        filterChain.doFilterChain(request, response,0);
        System.out.println(request.getStr());
        System.out.println(response.getStr().toString());
    }
}
