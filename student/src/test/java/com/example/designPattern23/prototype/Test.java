package com.example.designPattern23.prototype;

/**
 * @description: 原型模式也是克隆模式
 * @date: 2020/7/8 下午5:14
 * @author: zcy
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        String s= "zcy";
        Person person = new Person(22,s);
        Address bj = new Address(10001, "bj");
        person.setAddress(bj);
        Person p2 = (Person) person.clone();
        if (person == p2) {
            System.out.println("内存引用是一样");
        }else{
            System.out.println("内存引用不一样");
        }

        if(person.getAddress() == p2.getAddress()){
            System.out.println("地址内存引用是一样");
        }else{
            System.out.println("地址内存引用不一样");
        }

        if(person.getName() == p2.getName()){
            System.out.println("字符串内存引用是一样");
        }else{
            System.out.println("字符串内存引用不一样");
        }
        person.setName("abc");
        if(person.getName() == p2.getName()){
            System.out.println("字符串内存引用是一样");
        }else{
            System.out.println("字符串内存引用不一样");
        }
    }
}

/**
 * 克隆必须实现克隆接口，Cloneable是个标记型接口 如果没有实现cloneable接口，但重写了clone方法，在调用时会报错
 * 必须重写克隆方法，因为Object的克隆方法是protect的
 */
class Person implements Cloneable {
    private Integer age;
    private String name;
    private Address address;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.address = (Address) address.clone();
        return p;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

class Address implements Cloneable{
    private Integer roomNum;
    private String city;

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address(Integer roomNum, String city) {
        this.roomNum = roomNum;
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}