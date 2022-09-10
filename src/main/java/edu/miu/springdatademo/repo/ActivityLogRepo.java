package edu.miu.springdatademo.repo;

import edu.miu.springdatademo.aopAll.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogRepo extends JpaRepository<ActivityLog,Integer> {

}
