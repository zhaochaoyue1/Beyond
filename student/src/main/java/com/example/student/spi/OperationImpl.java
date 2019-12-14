package com.example.student.spi;

public class OperationImpl implements IOperation {
    @Override
    public int operation(int numberA, int numberB) {
        return numberA+numberB;
    }
}
