package com.example.instrumentation;

import org.apache.ibatis.javassist.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @description: PerfXformer
 * @date: 2022/3/22 下午4:33
 * @author: zcy
 * @version: 1.0
 */
public class PerfMonXformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        if (!className.equals("com/example/instrumentation/App")) {
            return classfileBuffer;
        }
        byte[] transformed = null;
        System.out.println("transforming " + className);
        ClassPool pool = ClassPool.getDefault();
        CtClass cl = null;
        try {
            cl = pool.makeClass(new ByteArrayInputStream(classfileBuffer));
            if(!cl.isInterface()){
                CtBehavior[] methods = cl.getDeclaredBehaviors();
                for (int i = 0; i < methods.length; i++) {
                    if(!methods[i].isEmpty()&&methods[i].getName().equals("test")){
                        doMethod(methods[i]);
                    }
                }
                transformed = cl.toBytecode();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(cl!=null){
                cl.detach();
            }
        }
        return transformed;
    }

    private void doMethod(CtBehavior method)throws NotFoundException, CannotCompileException {
        method.addLocalVariable("time",CtClass.longType);
        method.insertBefore("time = System.nanoTime();");
        method.insertAfter("System.out.println(\"leave method.getName()+and time: \"+(System.nanoTime()-time));");
    }
}
