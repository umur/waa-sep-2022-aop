package com.example.dayThree.controller;

import com.example.dayThree.Service.ActivityService;
import com.example.dayThree.entity.ActivityLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    ActivityService activityService;


    @GetMapping
    public List<ActivityLog> findAllActivity(){
        return activityService.findAllActivity();
    }
}
