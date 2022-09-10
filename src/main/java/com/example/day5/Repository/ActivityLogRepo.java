package com.example.day5.Repository;


import com.example.day5.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogRepo extends JpaRepository<ActivityLog,Integer> {


}
