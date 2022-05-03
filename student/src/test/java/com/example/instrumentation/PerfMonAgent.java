package com.example.instrumentation;

import java.lang.instrument.Instrumentation;

/**
 * @description: PerfMonAgent
 * @date: 2022/3/22 下午5:47
 * @author: zcy
 * @version: 1.0
 */
public class PerfMonAgent {
    //static private Instrumentation inst = null;
    public static void premain(String agentArgs,Instrumentation _inst){
        System.out.println("PerfMonAgent.premain() was called.");
        //Initialize the static variable we user to track information.
        //inst=_inst;
        //set up th class-file transformer.
        PerfMonXformer trans = new PerfMonXformer();
        System.out.println("adding a perfMonxformer instance to the JVM.");
        _inst.addTransformer(trans,true);
    }

    public static void agentmain(String agentArgs,Instrumentation _inst){
        System.out.println("JVM 运行时");
        //Initialize the static variable we user to track information.
        //inst=_inst;
        //set up th class-file transformer.
        PerfMonXformer trans = new PerfMonXformer();
        System.out.println("adding a perfMonxformer instance to the JVM.");
        _inst.addTransformer(trans,true);
    }
}
