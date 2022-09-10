package miu.edu.demo.aspect;

import miu.edu.demo.service.ActivityLogService;
import miu.edu.demo.service.impl.ActivityLogServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutiontimeAspect {
    @Autowired
    ActivityLogServiceImpl activityLogService;
    @Pointcut("@annotation(miu.edu.demo.aspect.annotation.Executiontime)")
    public void pointcutMethod(){}

    @Around("pointcutMethod()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long start = System.nanoTime();
        Object result = proceedingJoinPoint.proceed();
        Long finish = System.nanoTime();
        activityLogService.saveNewActivity(finish-start);
        return result;
    }
}
