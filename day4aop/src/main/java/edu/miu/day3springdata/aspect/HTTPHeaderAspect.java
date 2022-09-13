package edu.miu.day3springdata.aspect;

import edu.miu.day3springdata.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@Aspect
@Component
public class HTTPHeaderAspect {
    @Autowired
    private HttpServletRequest request;

    @Around("within(edu.miu.day3springdata.service.impl.* )")
    public Object proceed(ProceedingJoinPoint joinPoint) throws Throwable{
        if (request.getMethod().equals("POST")) {
            var header = request.getHeader("AOP-IS-AWSOME");
            if (header != null) {
                return joinPoint.proceed();
            } else {
                    throw new AopIsAwesomeHeaderException();
            }
        }
        return joinPoint.proceed();
    }

}
