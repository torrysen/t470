package com.lastwarmth.library;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler{

   @Override
   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       System.out.println("doing callback...");
       return null;
   }

}
