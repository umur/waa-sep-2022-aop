package com.example.assignment4.aspect;

import com.example.assignment4.entity.ActivityLog;
import com.example.assignment4.exception.AopIsAwesomeHeaderException;
import com.example.assignment4.repository.ActivityLogRepo;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Enumeration;

@Aspect
@Component
@RequiredArgsConstructor
public class LogAspect {

    private final HttpServletRequest httpRequest;

    private final ActivityLogRepo activityLogRepo;

    @Around("@annotation(com.example.assignment4.annotation.ExecutionTime) && execution(* com.example.assignment4.service..*())")
    public Object logToDB(ProceedingJoinPoint joinPoint) throws Throwable {
        Enumeration<String> aopHeader = httpRequest.getHeaders("AOP-IS-AWESOME");
        if(!httpRequest.getMethod().equals("POST")){
            return joinPoint.proceed();
        }
        if(!aopHeader.hasMoreElements()){
            throw new AopIsAwesomeHeaderException();
        }
        Long startTime = System.nanoTime();
        var result = joinPoint.proceed();
        Long endTime = System.nanoTime();
        Long duration = endTime - startTime;
        activityLogRepo.save(new ActivityLog(null, LocalDateTime.now(), joinPoint.getSignature().toLongString(), duration));
        return result;
    }
}
