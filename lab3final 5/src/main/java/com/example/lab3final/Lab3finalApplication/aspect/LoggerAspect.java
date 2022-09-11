package aspect;


import exceptions.HeaderNotFoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LoggerAspect {

//    @Pointcut("@annotation(edu.miu.springdatademo.aspect.MyLogger)")
//    public void selectMethods(){
//
//    }

    @Autowired
    private HttpServletRequest request;

    @Around("within(com.example.lab3final.Lab3finalApplication.controller.* )")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        if (request.getMethod().equals("POST")) {
            var header = request.getHeader("AOP-IS-AWESOME");
            if (header != null) {
                return joinPoint.proceed();
            } else {
                throw new HeaderNotFoundException();
            }
        } else {
            return joinPoint.proceed();
        }
    }

}
