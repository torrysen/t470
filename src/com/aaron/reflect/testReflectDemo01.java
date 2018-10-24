package com.aaron.reflect;

public class testReflectDemo01 {
    public static void main(String[] args) {
        Class<?> c = Dog.class;//得到Dog对应的Class对象
        Class<?> interfaces[] = c.getInterfaces();//获得Dog所实现的所有接口
        for (Class<?> inte : interfaces) {//打印
            System.out.println("Dog实现接口："+inte);
        }
    }
}