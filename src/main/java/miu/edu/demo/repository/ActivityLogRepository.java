package miu.edu.demo.repository;

import miu.edu.demo.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends CrudRepository<ActivityLog,Integer> {
}
