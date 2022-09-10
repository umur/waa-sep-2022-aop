package edu.miu.Demo.service.impl;

import edu.miu.Demo.entity.ActivityLog;
import edu.miu.Demo.repo.ActivityLogRepo;
import edu.miu.Demo.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
    private ActivityLogRepo activityLogRepo;

    @Autowired
    public ActivityLogServiceImpl(ActivityLogRepo activityLogRepo) {
        this.activityLogRepo = activityLogRepo;
    }

    public void save(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);
    }
}
