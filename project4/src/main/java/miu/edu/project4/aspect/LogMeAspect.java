package miu.edu.project4.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogMeAspect {

    @Pointcut("@annotation(miu.edu.project4.aspect.annotation.LogMe)")
        public void a(){
    }

    @Before("a()")
    public void log(JoinPoint joinPoint ){
        System.out.println( "Method name : " + joinPoint.getSignature().getName() );

    }
}
