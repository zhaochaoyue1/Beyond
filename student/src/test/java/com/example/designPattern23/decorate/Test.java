package com.example.designPattern23.decorate;

/**
 * @description: Test
 * @date: 2020/12/18 下午3:37
 * @author: zcy
 * @version: 1.0
 * <p>
 * https://www.cnblogs.com/yxlaisj/p/10446504.html
 * 装饰器模式：动态地给一个对象添加一些额外职责，就增加功能来说，装饰器模式比生成子类更灵活。
 */
public class Test {
    static void print(Coffee coffee) {
        System.out.println("花费了：" + coffee.getCost());
        System.out.println("配料：" + coffee.getIngredients());
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        print(simpleCoffee);
        WithMilk withMilk = new WithMilk(simpleCoffee);
        print(withMilk);
        WithSugar withSugar = new WithSugar(withMilk);
        print(withSugar);
    }
}
