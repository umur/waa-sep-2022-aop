package AopSpring.Aop.AspectSpring.service;



import AopSpring.Aop.AspectSpring.entity.ActivityLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityLogService {
  List<ActivityLog> findAll();
  void save(ActivityLog activityLog);
}
