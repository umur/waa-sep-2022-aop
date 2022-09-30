package com.example.demo.aspects;

import com.example.demo.Entity.ActivityLogEntity;
import com.example.demo.repository.ActivityLogRep;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Aspect
@Component
public class MyAspect {
    @Autowired
    private ActivityLogRep activityLogRep;
    private long start;
    private long end;

    @Autowired
    private HttpServletRequest request;

@Pointcut("@annotation(MyAnnotation)")
    public void excTimePointCut(){}


  @Before("excTimePointCut()")
    public void befor(){
         start =System.nanoTime();

    }

    @After("excTimePointCut()")
    public void after(JoinPoint joinPoint){
       end =System.nanoTime();


        ActivityLogEntity activityLogEntity =new ActivityLogEntity();
      activityLogEntity.setDate(LocalDate.now().toString());
        System.out.println(activityLogEntity.getDate());
      activityLogEntity.setOperation(joinPoint.getSignature().getName());
      activityLogEntity.setDuration(end-start);
        activityLogRep.save(activityLogEntity);

    }
    @Pointcut("execution(* com.example.demo.Controller.*.*(..))")
    public void headerCheckPointCut(){}


    @Around("headerCheckPointCut()")
    public Object aroundExample(ProceedingJoinPoint joinPoint) throws Throwable {
         if(request.getMethod().equals("POST")){
              if(request.getHeader("AOP-IS-AWESOME")!=null)
                  return joinPoint.proceed();
                  else
                      throw new AopIsAwesomeException();


         }
        return joinPoint.proceed();
    }
}
