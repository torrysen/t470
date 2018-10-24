package com.liuyx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * java动态代理有一定局限性，需要定义至少一个接口，使用cglib则不必如此
 * @author ZhenShengSu
 *
 */
public class InvocationHandlerTest implements InvocationHandler {

    private Object target;

    Object bind(Object i) {
        target = i;
        Object warpedItf;
        warpedItf = Proxy.newProxyInstance(target.getClass().getClassLoader(), i.getClass().getInterfaces(), this);
        return warpedItf;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method excute!");
        method.invoke(target, args);
        System.out.println("after method excute!");
        return null;
    }
    
    public static void main(String[] args) {
        Cls c = new Cls();
        InvocationHandlerTest pxy = new InvocationHandlerTest();
        Itf itf = (Itf)pxy.bind(c);
        System.out.println("printMe start-------------------");
        itf.printMe();
        System.out.println("printMe end-------------------");
        System.out.println("printSth start-------------------");
        itf.printSth("Hello, torrysen");
        System.out.println("printSth end-------------------");
    }

}