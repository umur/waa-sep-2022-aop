package com.example.dayThree.Service;

import com.example.dayThree.entity.ActivityLog;
import com.example.dayThree.repo.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    ActivityRepo activityRepo;
    public List<ActivityLog> findAllActivity() {
       return activityRepo.findAll();
    }
}
