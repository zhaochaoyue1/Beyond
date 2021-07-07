package com.example.mock;

import com.example.binarytree.TreeNode;
import junit.framework.TestCase;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.internal.builders.JUnit4Builder;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: Test
 * @date: 2021/5/17 下午5:44
 * @author: zcy
 * @version: 1.0
 */
public class Test extends TestCase {
   Mockery mock =  new JUnit4Mockery();

   @org.junit.Test
    public void testDriven(){
       /*IDriven driven = new Driven();
       final  ICar car = mock.mock(ICar.class);
       mock.checking(new Expectations(){{
           oneOf(car).run();
       }});
       driven.driven(car);*/
       Queue<TreeNode> q = new LinkedList<>();
       for(int i = 0;i<5;i++){
           q.add(null);
       }
   }
}
