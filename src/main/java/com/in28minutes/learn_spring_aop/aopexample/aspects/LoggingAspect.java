package com.in28minutes.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Configuration
@Aspect // 🌟 THE ASPECT: Declares this whole class as the container
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // 🎯 THE POINTCUT: Defines "Where" to intercept the code
    @Before("com.in28minutes.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")

    // 🛠️ THE ADVICE: The method itself defines "When" and "What" happens
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {

        // 💻 THE ADVICE LOGIC: The actual block of work being done
        logger.info("Before Aspect - Method is called - {} is called with arguments: {}", joinPoint, joinPoint.getArgs() );

    }

    // 🎯 THE POINTCUT: Defines "Where" to intercept the code
    @After("com.in28minutes.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.businessPackageConfig()")

    // 🛠️ THE ADVICE: The method itself defines "When" and "What" happens
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {

        // 💻 THE ADVICE LOGIC: The actual block of work being done
        logger.info("After Aspect - {} has executed", joinPoint);

    }

    // 🎯 THE POINTCUT: Defines "Where" to intercept the code
    @AfterThrowing(value="com.in28minutes.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.dataPackageConfig()", throwing = "exception")

    // 🛠️ THE ADVICE: The method itself defines "When" and "What" happens
    public void logMethodCallAfterThrowingExecution(JoinPoint joinPoint, Exception exception) {

        // 💻 THE ADVICE LOGIC: The actual block of work being done
        logger.info("After Aspect - {} has thrown exception {}", joinPoint, exception);

    }

    // 🎯 THE POINTCUT: Defines "Where" to intercept the code
    @AfterReturning(pointcut = "com.in28minutes.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.dataPackageConfig()", returning = "resultValue")

    // 🛠️ THE ADVICE: The method itself defines "When" and "What" happens
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {

        // 💻 THE ADVICE LOGIC: The actual block of work being done
        logger.info("After Aspect - {} has returned {}", joinPoint, resultValue);

    }

}