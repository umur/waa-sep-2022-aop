package AopSpring.Aop.AspectSpring.controller;


import AopSpring.Aop.AspectSpring.entity.ActivityLog;
import AopSpring.Aop.AspectSpring.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/activity-logs")
public class ActivityLogController {
  private final ActivityLogService service;

  @GetMapping
  public ResponseEntity<List<ActivityLog>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }
}
