package edu.miu.lab4.service;

import edu.miu.lab4.dto.ActivityLogDto;

import java.util.List;

public interface ActivityLogService {

    List<ActivityLogDto> findAll();
    ActivityLogDto findById(int id);
    ActivityLogDto add(ActivityLogDto activityLog);
    void update(int id, ActivityLogDto activityLog);
    void deleteById(int id);

}