package edu.miu.lab4.service.impl;

import edu.miu.lab4.dto.ActivityLogDto;
import edu.miu.lab4.entity.ActivityLog;
import edu.miu.lab4.repo.ActivityLogRepo;
import edu.miu.lab4.service.ActivityLogService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepo activityRepo;
    private final ModelMapper modelMapper;

    public ActivityLogServiceImpl(ActivityLogRepo activityRepo, ModelMapper modelMapper) {
        this.activityRepo = activityRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ActivityLogDto> findAll() {
        return ((List<ActivityLog>) activityRepo.findAll()).stream().map(p -> modelMapper.map(p, ActivityLogDto.class)).toList();
    }

    @Override
    public ActivityLogDto findById(int id) {
        ActivityLog activity = activityRepo.findById(id).orElse(null);
        return activity == null ? null : modelMapper.map(activity, ActivityLogDto.class);
    }

    @Override
    public ActivityLogDto add(ActivityLogDto activity) {
        ActivityLog c = modelMapper.map(activity, ActivityLog.class);
        ActivityLog saved = activityRepo.save(c);
        return modelMapper.map(saved, ActivityLogDto.class);
    }

    @Override
    public void update(int id, ActivityLogDto activity) {
        ActivityLog c = modelMapper.map(activity, ActivityLog.class);
        activityRepo.save(c);
    }

    @Override
    public void deleteById(int id) {
        activityRepo.deleteById(id);
    }

}
