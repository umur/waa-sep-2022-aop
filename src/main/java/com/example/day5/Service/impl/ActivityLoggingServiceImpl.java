package com.example.day5.Service.impl;

import com.example.day5.Repository.ActivityLogRepo;
import com.example.day5.Service.ActivityLoggingService;
import com.example.day5.entity.ActivityLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

@Service
public class ActivityLoggingServiceImpl implements ActivityLoggingService {
   @Autowired
   private ActivityLogRepo activityLogRepo;


    @Override
    public void saveActivity(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);
    }
}
