package AopSpring.Aop.AspectSpring.service.impl;


import AopSpring.Aop.AspectSpring.annotation.ExecutionTime;
import AopSpring.Aop.AspectSpring.entity.ActivityLog;
import AopSpring.Aop.AspectSpring.repository.ActivityLogRepo;
import AopSpring.Aop.AspectSpring.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
  private final ActivityLogRepo repo;

  @ExecutionTime
  @Override
  public List<ActivityLog> findAll() {
    var result = new ArrayList<ActivityLog>();
    try {
      var data = repo.findAll();
      data.forEach(result::add);
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return result;
  }

  @Override
  public void save(ActivityLog activityLog) {
    repo.save(activityLog);
  }
}
