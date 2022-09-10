package com.example.dayThree.aspect;

import com.example.dayThree.annotation.ExecutionTime;
import com.example.dayThree.entity.ActivityLog;
import com.example.dayThree.exception.AopIsAwesomeHeaderException;
import com.example.dayThree.repo.ActivityRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.function.ServerRequest;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;


@Aspect
@Component
public class LoggerAspect {

    @Autowired
    ActivityRepo activityRepo;
    @Autowired
    private HttpServletRequest request;
    @Pointcut("@annotation(com.example.dayThree.annotation.ExecutionTime)")
    public void timeTaken(){};


//    @Pointcut("execution(* com.example.dayThree.Service.*.*(..))")
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void allServicePost(){};


    @Around("timeTaken()")
    public Object calculateTimeTaken(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        ActivityLog activityLog = new ActivityLog();
        activityLog.setDate(LocalDate.now());
        activityLog.setDuration(finish - start);
        activityLog.setOperation(proceedingJoinPoint.getSignature().getName());

        activityRepo.save(activityLog);
        return result;
    }

    @Before("allServicePost()")
    public void checkService(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        String header = request.getHeader("AOP-IS-AWESOME");
//        if(header != null){
//            System.out.println("do something!");
//        }
//        else throw new  AopIsAwesomeHeaderException("No header AOP-IS-AWESOME");

    }




}
