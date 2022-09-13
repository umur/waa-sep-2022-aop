package edu.miu.day3springdata.aspect;

import edu.miu.day3springdata.entity.ActivityLog;
import edu.miu.day3springdata.repo.ActivityLogRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class ActivityLogAspect {

    @Autowired
    private ActivityLogRepo activityLogRepo;

    @Pointcut("@annotation(edu.miu.day3springdata.aspect.ExecutionTime)")
    public void logExecutionTime() {

    }

    @Around("logExecutionTime()")
    public Object calculateAndLogExecuteTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        String methodName = joinPoint.getSignature().toString();

        Object object = joinPoint.proceed();

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        ActivityLog activityLog = new ActivityLog(LocalDateTime.now(), methodName, duration);
        activityLogRepo.save(activityLog);

        return object;
    }

}
