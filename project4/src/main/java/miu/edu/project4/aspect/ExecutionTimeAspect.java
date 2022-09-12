package miu.edu.project4.aspect;


import miu.edu.project4.aspect.annotation.ExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;


    @Pointcut("@annotation(miu.edu.project4.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){
    }


    @Around("executionTimeAnnotation()")
    public  Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {
        if(request.getMethod().equals("POST")  && request.getHeader("AOP-IS-AWESOME" )!= null){
//            request.getHeader("AOP --- ");

            throw new Exception("habibi matched ");

        }

        proceedingJoinPoint.proceed();

        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();

        System.out.println(proceedingJoinPoint.getSignature().getName() + "takes ns : " +finish);

        return result;

    }

}
