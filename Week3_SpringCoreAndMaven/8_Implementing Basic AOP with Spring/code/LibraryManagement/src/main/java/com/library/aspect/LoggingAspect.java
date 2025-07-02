package com.library.aspect;

public class LoggingAspect {


    public void beforeAdvice() {
        System.out.println("Logging aspect before call addBook method!");
    }

    public void afterAdvice() {
        System.out.println("Logging aspect after call addBook method!");
    }

}
