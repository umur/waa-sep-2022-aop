package miu.edu.project4.service.imp;

import miu.edu.project4.entity.ActivityLog;
import miu.edu.project4.repo.ActivityLogRepo;
import miu.edu.project4.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImp implements ActivityLogService {

    @Override
    public void save(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);
    }
    @Autowired
    private  ActivityLogRepo  activityLogRepo;




}
