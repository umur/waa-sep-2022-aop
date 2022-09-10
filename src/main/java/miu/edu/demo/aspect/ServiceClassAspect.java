package miu.edu.demo.aspect;

import miu.edu.demo.AopIsAwesomeHeaderException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.stream.Collectors;

@Aspect
@Component
public class ServiceClassAspect {

    @Pointcut("within(miu.edu.demo.service..*)")
    public void servicePointCut(){}
    @Before("servicePointCut()")
    public Object postHeaderCheck(JoinPoint joinPoint) throws Throwable {
        int flag =0;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        if(request.getMethod().equals("POST")){
            Enumeration<String> headers = request.getHeaderNames();
                while (headers.hasMoreElements()) {
                    if(request.getHeader(headers.nextElement()).equals("AOP-IS-AWESOME")){
                        flag =1;
                        break;
                    }
            }
            if(flag == 0)
                throw new AopIsAwesomeHeaderException("Aop Is Awesome Header not found");
        }

        return null;
    }
}
