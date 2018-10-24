package com.liuyx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StandardInvocation implements InvocationHandler {

	/**
	 * 这里面有一个obj，这个obj是必须的，我们既然要做代理，我们必须知道我们是给谁做代理，这里的obj就是被代理者
	 * 动态代理说到底也是代理，代理模式里就要求有一个被代理者。
	 */
    private Object obj;
    
    StandardInvocation(Object obj){
        this.obj=obj;
    }
    
    @Override
    /**
     * invoke的三个参数、第一个参数就是代理者，
     * 如果你想对代理者做一些操作可以使用这个参数；第二个就是被执行的方法，第三个是执行该方法所需的参数。
     * 当你执行代理者的某个方法的时候，最后跑的都是invoke方法
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method excute!");
        Object result = method.invoke(obj, args);
        System.out.println("after method excute!");
        return result;
    }

}