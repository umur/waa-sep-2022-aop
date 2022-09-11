package edu.miu.aspect;

import edu.miu.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ExceptionAspect {

   @Autowired
    private HttpServletRequest request;

   /*@Around("within(edu.miu.controller.*)")
    public Object log(ProceedingJoinPoint joinPoint) throws AopIsAwesomeHeaderException {
       if(request.getMethod().equals("POST")) {
           var header : String = request.getHeader("AOP-IS-AWESOME");
           if(header != null) {
               return joinPoint.proceed();
           }
           else {
               throw new AopIsAwesomeHeaderException();
           }
       }

    }*/


//    @Around("selectMethods()")


//    @Pointcut()


    /*
    * @After("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void aopIsAwesomeInHeader(JoinPoint jp)
    {
        System.out.println("Aspect started.....");
        Object[] args = jp.getArgs();
        Map<String,String> headers = (Map<String, String>) args[0];
        headers.forEach((key, value)->{
            /// Set the cookie header in postman with "AOP-IS-AWESOME" for testing
            if(!value.equals("AOP-IS-AWESOME"))
            {

                throw new AopIsAwesomeException();
            }
            else
            { System.out.println("Here we go ........");}
        });
    }*/
}
