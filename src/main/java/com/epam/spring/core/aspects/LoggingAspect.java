package com.epam.spring.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
    private static final Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* *.logEvent(..))")
    private void allLogEventMethods(){}

    @Before("allLogEventMethods()")
    public void logBefore(JoinPoint joinPoint) {
        LOG.info("BEFORE :" +
                joinPoint.getTarget()
                    .getClass().getSimpleName()
                + " " +
                joinPoint.getSignature()
                    .getName());
    }

    @AfterReturning(
            pointcut = "allLogEventMethods()",
            returning = "retVal"
    )
    public void logAfter(Object retVal) {
        LOG.info("Return value: " + retVal);
    }

    @AfterThrowing(
            pointcut = "allLogEventMethods()",
            throwing = "ex"
    )
    public void logAfterThrow(Throwable ex) {
        LOG.warn("Thrown: " + ex);
    }
}
