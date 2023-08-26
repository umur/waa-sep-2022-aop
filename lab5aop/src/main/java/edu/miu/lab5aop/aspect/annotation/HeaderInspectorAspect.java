package edu.miu.lab5aop.aspect.annotation;

import edu.miu.lab5aop.exception.AopIsAwesomeHeaderException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
@RequiredArgsConstructor
public class HeaderInspectorAspect {

    private final HttpServletRequest request;

    @Pointcut("within(edu.miu.lab5aop.service..*)")
    public void inspectHeader() {
    }

    @Before("inspectHeader()")
    public void calculateExecutionTime() {
        if("POST".equalsIgnoreCase(request.getMethod())) {
            String aopHeader = request.getHeader("AOP-IS-AWESOME");
            if(aopHeader == null || aopHeader.isEmpty()) {
                throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header must be provided");
            }
        }
    }
}
