package edu.miu.Demo.aspect;

import edu.miu.Demo.entity.ActivityLog;
import edu.miu.Demo.exception.AopIsAwesomeHeaderException;
import edu.miu.Demo.service.ActivityLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

@Aspect
@Component
public class ExecutionTimeAspect {
    HttpServletRequest request;
    ActivityLogService activityLogService;

//    @Autowired
//    HttpServletResponse response;

    @Autowired
    public ExecutionTimeAspect(HttpServletRequest request, ActivityLogService activityLogService) {
        this.request = request;
        this.activityLogService = activityLogService;
    }

    @Pointcut("@annotation(edu.miu.Demo.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){}

    @Around("executionTimeAnnotation()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // special condition
        if (request.getMethod().equals("POST") && request.getHeader("AOP-IS-AWESOME") != null) {
            throw new AopIsAwesomeHeaderException("Condition matched");
        }

        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long end = System.nanoTime();
        long elapsed = end - start;
        double total = (double) elapsed / 1_000_000_000;

        ActivityLog log = new ActivityLog();

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH:mm").format(new java.util.Date());
        log.setExecutionTime(timeStamp);
        log.setDuration(total);
        log.setOperation(proceedingJoinPoint.getSignature().getName());

        activityLogService.save(log);
        return result;
    }
}
