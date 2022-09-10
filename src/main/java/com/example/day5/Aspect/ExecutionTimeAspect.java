package com.example.day5.Aspect;

import com.example.day5.Service.ActivityLoggingService;
import com.example.day5.entity.ActivityLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    private ActivityLoggingService activityLoggingService;
    @Pointcut("@annotation(com.example.day5.Aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){

    }


    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + finish);

        ActivityLog activityLog= new ActivityLog(LocalDate.now(),proceedingJoinPoint.getSignature().getName(),finish-start);

        activityLoggingService.saveActivity(activityLog);
        return result;
    }
}
