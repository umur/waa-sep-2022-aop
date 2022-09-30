package com.example.demo.repository;

import com.example.demo.Entity.ActivityLogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRep extends CrudRepository<ActivityLogEntity,Integer> {

}
