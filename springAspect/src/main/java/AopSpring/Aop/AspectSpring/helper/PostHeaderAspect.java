package AopSpring.Aop.AspectSpring.helper;



import io.swagger.models.HttpMethod;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class PostHeaderAspect {
  @Pointcut("within(AopSpring.Aop.AspectSpring.service..*..*)")
  public void checkPostHeader(){}

  @Before("checkPostHeader()")
  public void check(JoinPoint joinPoint) {

    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

    if(HttpMethod.POST.matches(request.getMethod()) && request.getHeader("AOP-IS-AWESOME") == null) {
      throw new AOPIsAwesomeException("AOP-Is-Awsome");
    }
  }

}
