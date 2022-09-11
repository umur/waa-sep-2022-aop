package com.ultrates.lab4springaop.service.impl;

import com.ultrates.lab4springaop.dto.ActivityLogDto;
import com.ultrates.lab4springaop.entity.ActivityLog;
import com.ultrates.lab4springaop.repository.ActivityLogRepo;
import com.ultrates.lab4springaop.service.ActivityLogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ActivityLogServiceImpl implements ActivityLogService {

    @Autowired
    private ActivityLogRepo activityLogRepo;
    @Autowired
    private ModelMapper modelMapper ;

    @Override
    public void save(ActivityLogDto a) {
        ActivityLog activityLog = modelMapper.map(a, ActivityLog.class);
        activityLogRepo.save(activityLog);

    }

    @Override
    public void deleteById(int id) {
        activityLogRepo.deleteById(id);
    }

    @Override
    public ActivityLogDto getById(int id) {
        return modelMapper.map(activityLogRepo.findById(id).get(), ActivityLogDto.class);
    }

    @Override
    public List<ActivityLogDto> getAll() {
        var result  = new ArrayList<ActivityLogDto>();
        activityLogRepo.findAll().forEach(a -> result.add(modelMapper.map(a, ActivityLogDto.class)));
        return result;
    }
}
