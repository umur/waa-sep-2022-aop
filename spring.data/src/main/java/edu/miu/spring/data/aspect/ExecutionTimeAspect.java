package edu.miu.spring.data.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;

public class ExecutionTimeAspect {

    @Pointcut("@annotation(edu.miu.spring.data.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){
    }

    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() + "AopIsAwesomeHeaderException: " + finish);
        return result;
    }
}

