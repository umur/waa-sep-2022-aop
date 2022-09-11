package com.ultrates.lab4springaop.controller;

import com.ultrates.lab4springaop.aspect.annotation.ExecutionTime;
import com.ultrates.lab4springaop.dto.ActivityLogDto;
import com.ultrates.lab4springaop.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activitylogs")
public class ActivityLogController {

    @Autowired
    private ActivityLogService activityLogService;

    @ExecutionTime
    @PostMapping
    public void save(@RequestBody ActivityLogDto u) {
        activityLogService.save(u);
    }

    @ExecutionTime
    @GetMapping
    public List<ActivityLogDto> getAll() {
        return activityLogService.getAll();
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public ResponseEntity<ActivityLogDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(activityLogService.getById(id));
    }

    @ExecutionTime
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        activityLogService.deleteById(id);
    }
}
