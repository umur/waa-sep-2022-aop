package com.aop.springaop.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    @Pointcut("@annotation(com.aop.springaop.Aspect.ExecutionTime)")
    public void pointCut(){}

    @Around("pointCut()")
    public void prformanceManagment(ProceedingJoinPoint proceedingJoinPoint){

    }


}
