package com.example.inLectureExamle.AOP;

import com.example.inLectureExamle.ApoIsAwesomeHeaderException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;

import java.time.LocalDate;

import static org.apache.catalina.valves.AbstractAccessLogValve.localDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ActivityLogAspect {
    private final HttpServletRequest httpServletRequest;
    private final ActivityLogRepository activityLogRepository;

    @Pointcut("@annotation(...)")
        public void executionTimeAnnotation(){

    }
    @Around("executionTimeAnnotation()")
    public Object calculateTime(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
        long start = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();

        ActivityLog log = new ActivityLog();
        log.setLocalDate((LocalDate.now()));
        log.setDuration(finish - start);
        log.setOperation(proceedingJoinPoint.getSignature().toShortString());
        activityLogRepository.save(log);
        return proceed;
    }

    @Pointcut("execution(...())")
    public void servicesExecutionPointCut(){

    }

    @Before("servicesExecutionPointCut()")
    public void serviceGuardForPostMethod(JointPoint jointPoint) throws ApoIsAwesomeHeaderException {
       if(httpServletRequest.getMethod().equals("POST")){
           if(httpServletRequest.getHeader("AOP-IS-AWESOME") == null){
               throw new ApoIsAwesomeHeaderException("AOP-IS-AWESOME is required in Header !");
           }
       }
    }
}
