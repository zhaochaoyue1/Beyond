package com.example.student.Test;

import com.example.student.spi.DivisionOperationImpl;
import com.example.student.spi.IOperation;
import com.example.student.spi.OperationImpl;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestSpi {
    public static void main(String[] args) {
        IOperation operation = new OperationImpl();
        IOperation divOperation = new DivisionOperationImpl();
        System.out.println(operation.operation(6, 3));
        System.out.println(divOperation.operation(6, 3));
        ServiceLoader<IOperation> load = ServiceLoader.load(IOperation.class);
        Iterator<IOperation> iterator = load.iterator();
        System.out.println("classPath:" + System.getProperty("java.class.path"));
        while (iterator.hasNext()) {
            IOperation next = iterator.next();
            System.out.println(next.operation(6, 3));
        }
    }
}
