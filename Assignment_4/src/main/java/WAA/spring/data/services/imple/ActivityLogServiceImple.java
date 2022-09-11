package WAA.spring.data.services.imple;

import WAA.spring.data.entity.ActivityLog;
import WAA.spring.data.repository.ActivityLogRepo;
import WAA.spring.data.services.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImple implements ActivityLogService {

    private final ActivityLogRepo activityLogRepo;

    @Override
    public void save(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);
    }
}
