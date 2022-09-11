package com.ultrates.lab4springaop.aspect;

import com.ultrates.lab4springaop.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AopIsAwesomeAspect {

    private HttpServletRequest httpServletRequest;
    //create a pointcu declaration to

    @Pointcut("within(com.ultrates.lab4springaop.service..*)")
    private static void aopIsAwsome(){}


    //create addvice to use the above pointcut.
    @Before("aopIsAwsome()")
    public  void aopIsAwesomeAspectAdvice(JoinPoint joinPoint) throws Throwable{
        //if clase to chech if the http request is post type and hase a header of "aop-is -awsome
        if(httpServletRequest.getMethod().equals("POST")&&(httpServletRequest.getHeader("AOP-IS-AWESOME")==null)){

            throw new AopIsAwesomeHeaderException("No header AOP-IS -AWESOME  found");
        }
    }
}
