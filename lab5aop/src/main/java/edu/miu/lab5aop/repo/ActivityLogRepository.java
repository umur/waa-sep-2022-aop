package edu.miu.lab5aop.repo;

import edu.miu.lab5aop.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends CrudRepository<ActivityLog, Integer> {
}
