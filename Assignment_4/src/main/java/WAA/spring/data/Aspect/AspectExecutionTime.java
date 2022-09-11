package WAA.spring.data.Aspect;

import WAA.spring.data.entity.ActivityLog;
import WAA.spring.data.services.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectExecutionTime {

    private ActivityLogService activityLogService;

    public AspectExecutionTime(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    @Pointcut("@annotation(WAA.spring.data.annotation.ExecutionTime)")
    public void executionTimePc(){}

    @Around("executionTimePc()")
    public Object excutionTimeCaluculator(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + finish);
        ActivityLog a=(ActivityLog)proceedingJoinPoint;
        a.setDuration(finish);
        a.setNameOfTheMethod(proceedingJoinPoint.getSignature().getName());
        activityLogService.save(a);
        return result;
    }
}
