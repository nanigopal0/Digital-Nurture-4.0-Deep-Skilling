package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;


public class LoggingAspect {


    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        System.out.println("Logging aspect before call bookService method!");
        long startTime = System.nanoTime();
        try {
            obj = joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("Exception occurred: " + throwable.getMessage());
        }
        long endTime = System.nanoTime();
        System.out.println("Logging aspect after call bookService method! Time taken: " + (endTime - startTime) + " ns");
        return obj;
    }
}
