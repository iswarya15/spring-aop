package com.in28minutes.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Around("com.in28minutes.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        Start a time
            long startTimeMills = System.currentTimeMillis();

//        Execute the method
           Object returnValue = proceedingJoinPoint.proceed();

//        Stop the timer
            long stopTimeMills = System.currentTimeMillis();

            long executionDuration = stopTimeMills - startTimeMills;

            logger.info("Around Aspect - {} Method executed in {} ms",proceedingJoinPoint,executionDuration);

            return returnValue;
    }
}
