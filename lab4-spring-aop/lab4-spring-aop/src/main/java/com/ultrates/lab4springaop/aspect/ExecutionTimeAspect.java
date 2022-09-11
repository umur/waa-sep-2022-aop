package com.ultrates.lab4springaop.aspect;

import com.ultrates.lab4springaop.dto.ActivityLogDto;
import com.ultrates.lab4springaop.service.ActivityLogService;
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
    private ActivityLogService activityLogService;

    //create the annotation type pointcut, to detect the custom annotation in the methods inside the  service directory in the  base package.

    @Pointcut("@annotation(com.ultrates.lab4springaop.aspect.annotation.ExecutionTime)")
//this means will detect the methods in this package that are annatated will @executionTime
    public void executionTimeAnnotationAdvice() {
    }

    //create an advice of type @Around for the above point cut, to do something  if the pointcut predicate expression fullfils.
    @Around("executionTimeAnnotationAdvice()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {


        long start = System.nanoTime();       //start clock time acts as @Before advice
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();         //end clock to act as @AfterRunning advice
        System.out.println(proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName() + "========>" + proceedingJoinPoint.getSignature().getName());


        LocalDate now = LocalDate.now();
        String operation = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName() + "===========>" + proceedingJoinPoint.getSignature().getName();
        double duration = finish - start;

        ActivityLogDto a = new ActivityLogDto(now, operation, duration);
        activityLogService.save(a);

        return result;
    }
}