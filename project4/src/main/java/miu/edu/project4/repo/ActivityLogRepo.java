package miu.edu.project4.repo;

import miu.edu.project4.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog, Integer> {


}
