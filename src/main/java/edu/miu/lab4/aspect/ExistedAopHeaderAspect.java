package edu.miu.lab4.aspect;

import edu.miu.lab4.exceptions.AopIsAwesomeHeaderException;
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
public class ExistedAopHeaderAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Pointcut("@annotation(edu.miu.lab4.aspect.annotation.ExistedAopHeader)")
    public void existedAopHeaderAnnotation() {
    }

    @Around("existedAopHeaderAnnotation()")
    public Object checkAopHeader(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if (request.getHeader("AOP-IS-AWESOME") == null) {
            throw new AopIsAwesomeHeaderException("Header AOP-IS-AWESOME not found");
        }

        return proceedingJoinPoint.proceed();
    }

}
