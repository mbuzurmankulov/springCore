package com.epam.spring.core.aspects;

import lombok.Getter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class StatisticAspect {

    @Getter
    private Map<Class<?>,Integer>  statistics = new HashMap<>();

    @Pointcut("execution(* com.epam.spring.core.loggers.*.logEvent(..))")
    private void allLogEventMethods(){}

    @AfterReturning("allLogEventMethods()")
    private void countLogging(JoinPoint joinPoint){
        Class aClass = joinPoint.getTarget().getClass();
        Integer newCount = statistics.containsKey(aClass) ?
                            statistics.get(aClass) + 1 : 1;
        statistics.put(aClass, newCount);
    }

}
