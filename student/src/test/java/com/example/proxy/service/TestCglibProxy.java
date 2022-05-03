package com.example.proxy.service;


import com.example.proxy.service.impl.AdminServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * CGLIB代理： 实现原理类似于JDK动态代理，只是他在运行期间生成的代理对象时针对目标类扩展的子类
 * CGLIB是高效的代码生成包，底层是依靠ASM(开源的java字节码编辑类库）操作字节码实现的，性能比JDK强。
 */
public class TestCglibProxy {
    public static void main(String[] args) {
        /*------------------------获取代理类源码-------------------------*/
        String path = AdminServiceCglibProxy.class.getResource(".").getPath();
        System.out.println(path);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, path);

        AdminServiceImpl adminService = new AdminServiceImpl();
        AdminServiceCglibProxy proxy = new AdminServiceCglibProxy(adminService);
        Object proxy1 = proxy.getProxy();
        AdminServiceImpl a = (AdminServiceImpl) proxy1;
        a.find();
    }
}
