package AopSpring.Aop.AspectSpring.repository;


import AopSpring.Aop.AspectSpring.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog, Integer> {
}
