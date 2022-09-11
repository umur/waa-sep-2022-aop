package AopSpring.Aop.AspectSpring.helper;

import AopSpring.Aop.AspectSpring.entity.ActivityLog;
import AopSpring.Aop.AspectSpring.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {
  private final ActivityLogService activityLogService;

  @Pointcut("@annotation(AopSpring.Aop.AspectSpring.annotation.ExecutionTime)")
  public void runtime(){}

  // common solution
  @Around("runtime()")
  public Object calculateRuntime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    var result = proceedingJoinPoint.proceed();
    long end = System.currentTimeMillis();
    activityLogService.save(new ActivityLog(0, System.currentTimeMillis(), proceedingJoinPoint.getSignature().toString(), end-start));
    return result;

  }
}
