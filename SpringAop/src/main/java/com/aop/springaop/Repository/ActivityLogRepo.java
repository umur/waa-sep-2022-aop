package com.aop.springaop.Repository;

import com.aop.springaop.Model.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog,Integer> {
}
