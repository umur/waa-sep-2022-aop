package henry.waasep2022aop.aspect;

import henry.waasep2022aop.exception.AopHeaderNotFoundException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@RequiredArgsConstructor
public class HeaderCheckAspect {
    private final HttpServletRequest httpServletRequest;
    @Pointcut("within(henry.waasep2022aop.service..*)")
    public void headerCheckAnnotation() {
    }

    @Before("headerCheckAnnotation()")
    public void checkHeader() {
        if (httpServletRequest.getMethod().equalsIgnoreCase("POST")) {
            String aopHeader = httpServletRequest.getHeader("AOP-IS-AWESOME");
            if (aopHeader == null || aopHeader.isEmpty()) {
                throw new AopHeaderNotFoundException("No AOP-IS-AWESOME header found.");
            }
        }
    }
}
