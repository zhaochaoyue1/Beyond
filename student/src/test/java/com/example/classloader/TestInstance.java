package com.example.classloader;

public class TestInstance {
    public static int a;
    public static int b = 1;
    public static TestInstance testInstance = new TestInstance();

    public TestInstance() {
        a++;
        b++;
    }


}
class Test{
    public static void main(String[] args) {
        System.out.println(TestInstance.a);
        System.out.println(TestInstance.b);
    }
}
