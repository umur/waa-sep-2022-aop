package edu.miu.aspect.aspect;

import edu.miu.aspect.entity.ActiveLog;
import edu.miu.aspect.exception.AopIsAwesomeHeaderException;
import edu.miu.aspect.repo.ActiveLogRepo;
import org.apache.tomcat.jni.Proc;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

@Aspect
@Component
public class LoggerAspect {
    @Autowired
    ActiveLogRepo activeLogRepo;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @Pointcut("@annotation(edu.miu.aspect.annotation.ExecutionTime)")
    public void execTime(){}




    @Around("execTime()")
    public Object execTimeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        var start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        var finish = System.nanoTime();
        ActiveLog activeLog = new ActiveLog();
        activeLog.setDate(LocalDate.now());
        activeLog.setDuration(String.valueOf((finish-start)) + " ns");
        activeLog.setOperation(proceedingJoinPoint.getSignature().getName());
        activeLogRepo.save(activeLog);
        return result;
    }



    @Before("execution(* edu.miu.aspect.service.*.*(..))")
    public void headerChecker(JoinPoint joinPoint){
        if(request.getMethod().equals("POST") && request.getHeader("myHeader").equals("AOP-IS-AWESOME")){
            System.out.println("HeaderChecker");
            System.out.println("Request method: " + request.getMethod());
            System.out.println("Request Header: " + request.getHeader("myHeader"));
        }else {
            throw new AopIsAwesomeHeaderException("No header AOP-IS AWESOME found on Post Request");
        }

    }
}
