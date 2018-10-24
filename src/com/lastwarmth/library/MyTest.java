package com.lastwarmth.library;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * https://blog.csdn.net/leslietuang/article/details/51203692
 * 使用Proxy类与InvocationHandler接口
 * java.lang.reflect.Proxy：这是 Java 动态代理机制的主类，它提供了一组静态方法来为一组接口动态地生成代理类及其对象
 */
 
public class MyTest {
 
    public static void main(String[] args) {
        try {
            Class<?> mClass = Class.forName("com.lastwarmth.library.MyLibrary");
            Class<?> mCallback = Class.forName("com.lastwarmth.library.MyLibrary$Callback");
            MyHandler mHandler = new MyHandler();
            
            // 该方法用于为指定类装载器、一组接口及调用处理器生成 动态代理类实例 
            Object mObj = Proxy.newProxyInstance(MyTest.class.getClassLoader(), new Class[] { mCallback }, mHandler);
            //Method mMethod = mClass.getDeclaredMethod("mainMethod", new Class[] { mCallback });
            Method mMethod = mClass.getDeclaredMethod("mainMethod", mCallback);
            //mMethod.invoke(mClass.newInstance(), new Object[] { mObj });
            
            mMethod.invoke(mClass.newInstance(), mObj);
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
 
}