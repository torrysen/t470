package com.lastwarmth.library;

public class MyLibrary {
	 
    public interface Callback {
        void doCallback();
    }
 
    public void mainMethod(Callback callback) {
        System.out.println("doing main...");
        callback.doCallback();
    }
}