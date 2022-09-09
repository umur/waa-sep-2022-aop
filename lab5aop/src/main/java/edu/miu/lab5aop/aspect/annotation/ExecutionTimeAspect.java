package edu.miu.lab5aop.aspect.annotation;

import edu.miu.lab5aop.entity.ActivityLog;
import edu.miu.lab5aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final ActivityLogService activityLogService;

    @Pointcut("@annotation(edu.miu.lab5aop.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        long completedTime = finish - start;
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + completedTime);
        ActivityLog activityLog = ActivityLog.builder()
                .methodName(proceedingJoinPoint.getSignature().getName())
                .duration(completedTime)
                .date(LocalDateTime.now())
                .build();
        activityLogService.save(activityLog);
        return result;
    }

}
