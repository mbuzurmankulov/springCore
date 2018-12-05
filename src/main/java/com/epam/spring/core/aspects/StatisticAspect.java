package com.epam.spring.core.aspects;

import lombok.Getter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class StatisticAspect {
    private static final Logger LOG = LoggerFactory.getLogger(StatisticAspect.class);

    @Getter
    private Map<Class<?>,Integer>  statistics = new HashMap<>();

    @Pointcut("execution(* *.logEvent(..))")
    private void allLogEventMethods(){}

    @AfterReturning("allLogEventMethods()")
    private void countLogging(JoinPoint joinPoint){
        Class aClass = joinPoint.getTarget().getClass();
        Integer newCount = statistics.containsKey(aClass) ?
                            statistics.get(aClass) + 1 : 1;
        statistics.put(aClass, newCount);
    }

}
