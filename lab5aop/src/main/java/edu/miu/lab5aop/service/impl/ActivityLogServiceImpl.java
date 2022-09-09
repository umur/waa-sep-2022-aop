package edu.miu.lab5aop.service.impl;

import edu.miu.lab5aop.entity.ActivityLog;
import edu.miu.lab5aop.repo.ActivityLogRepository;
import edu.miu.lab5aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository activityLogRepository;

    @Override
    @Transactional
    public void save(ActivityLog activityLog) {
        activityLogRepository.save(activityLog);
    }
}
