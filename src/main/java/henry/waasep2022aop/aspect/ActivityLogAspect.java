package henry.waasep2022aop.aspect;

import henry.waasep2022aop.entity.ActivityLog;
import henry.waasep2022aop.repo.ActivityLogRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class ActivityLogAspect {
    @Autowired
    private ActivityLogRepo activityLogRepo;

    @Pointcut("@annotation(henry.waasep2022aop.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){
    };

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        Object result = proceedingJoinPoint.proceed();
        long end = System.nanoTime();

        ActivityLog activityLog = new ActivityLog();
        activityLog.setDuration(end - start);
        activityLog.setDate(new Date());
        activityLog.setOperation(proceedingJoinPoint.getSignature().getName());
        activityLogRepo.save(activityLog);

        return result;
    }
}
