package com.example.test2;

import sun.tools.jconsole.Tab;

public class TestInit {

    public static void main(String[] args) {
        System.out.println("main()");
        cupboard.otherMethod(1);


    }
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
class Bowl{
    Bowl(int marker){
        System.out.println("Bowl("+marker+")");
    }
}

class Tableware{
    static Bowl bowl7 = new Bowl(7);
    static {
        System.out.println("Tableware静态代码块");
    }
    Tableware(){
        System.out.println("Tableware构造方法");
    }
    Bowl bowl6 = new Bowl(6);
}

class Table extends Tableware{
    {
        System.out.println("Table非静态代码块_1");
    }
    Bowl bowl5 = new Bowl(5);
    {
        System.out.println("Table非静态代码块_2");
    }
    static Bowl bowl1 = new Bowl(1);
    static {
        System.out.println("Table静态代码快");
    }
    Table(){
        System.out.println("Table构造方法");
    }
    static  Bowl Bowl2 = new Bowl(2);
}

class Cupboard extends Tableware{
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    Cupboard(){
        System.out.println("Cupboard构造方法");
    }
    void otherMethod(int marker){
        System.out.println("otherMethod("+marker+")");
    }
    static Bowl bowl5 = new Bowl(5);
}

