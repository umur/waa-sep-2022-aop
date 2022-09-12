package com.aop.springaop.Service.Impl;

import com.aop.springaop.Model.ActivityLog;
import com.aop.springaop.Repository.ActivityLogRepo;
import com.aop.springaop.Service.ActivityLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
    private ActivityLogRepo activityLogRepo;
    public ActivityLogServiceImpl(ActivityLogRepo activityLogRepo){
        this.activityLogRepo=activityLogRepo;
    }

    @Override
    public List<ActivityLog> findAll() {
        return (List<ActivityLog>) activityLogRepo.findAll();
    }

    @Override
    public ActivityLog findById(int id) {
        if(activityLogRepo.findById(id).isPresent()){
            return activityLogRepo.findById(id).get();
        }
        return null;
    }

    @Override
    public ActivityLog addActivity(ActivityLog activityLog) {
        return activityLogRepo.save(activityLog);
    }
}
