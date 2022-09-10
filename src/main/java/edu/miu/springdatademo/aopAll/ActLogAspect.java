package edu.miu.springdatademo.aopAll;

import edu.miu.springdatademo.repo.ActivityLogRepo;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ActLogAspect {
    private final ActivityLogRepo activityLogRepo;
    private final HttpServletRequest httpServletRequest;

    @Pointcut("@annotation(edu.miu.springdatademo.aopAll.ExecutionTime)")
    public void executionTimeAnnotation(){

    }
    @Around("executionTimeAnnotation()")
    public Object durationTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime =System.nanoTime();
        Object proceed =proceedingJoinPoint.proceed();
        long finishTime=System.nanoTime();

        ActivityLog activityLog=new ActivityLog();
        activityLog.setDate(LocalDate.now());
        activityLog.setDuration(finishTime-startTime);
        activityLog.setOperation(proceedingJoinPoint.getSignature().toShortString());
        System.out.println("msg");
        activityLogRepo.save(activityLog);
        return proceed;
    }
    @Pointcut("execution(* edu.miu.springdatademo.services.*.*(..))" )
    public void serviceExecutionPointcut(){

    }
    @Before("serviceExecutionPointcut()")
    public void serviceGuardForPostMethods(JoinPoint joinPoint) throws AOPException{
        if(httpServletRequest.getMethod().equals("POST")){
            if(httpServletRequest.getHeader("AOP-IS-AWESOME")==null){
                throw new AOPException("AOP-IS-AWESOME is required is Header!");
            }

        }
    }
}
