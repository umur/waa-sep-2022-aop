package com.example.dayThree.repo;

import com.example.dayThree.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepo extends JpaRepository<ActivityLog, Long> {
}
