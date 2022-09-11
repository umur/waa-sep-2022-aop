package com.ultrates.lab4springaop.service;

import com.ultrates.lab4springaop.dto.ActivityLogDto;

import java.util.List;

public interface ActivityLogService {
    void save(ActivityLogDto a);
    void deleteById(int id);
    ActivityLogDto getById(int id);
    List<ActivityLogDto> getAll();
}
