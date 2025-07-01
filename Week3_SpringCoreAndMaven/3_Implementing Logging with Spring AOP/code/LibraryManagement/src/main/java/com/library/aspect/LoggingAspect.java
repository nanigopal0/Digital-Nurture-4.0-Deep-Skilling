package com.library.aspect;

import org.springframework.stereotype.Component;

@Component

public class LoggingAspect {


    public void logExecutionTime() {
        System.out.println("Logging aspect executed!");
    }
}
