package miu.edu.demo.service.impl;

import miu.edu.demo.entity.ActivityLog;
import miu.edu.demo.repository.ActivityLogRepository;
import miu.edu.demo.service.ActivityLogService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    @Autowired
    ActivityLogRepository activityLogRepository;

    public void saveNewActivity(double duration){
        Date today = new Date(0);
        ActivityLog ac = new ActivityLog(today,"",duration);
        activityLogRepository.save(ac);
    }
}
