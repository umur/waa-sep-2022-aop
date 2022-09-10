package edu.miu.lab4.controller;

import edu.miu.lab4.dto.ActivityLogDto;
import edu.miu.lab4.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/activityLogs")
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    @GetMapping()
    public List<ActivityLogDto> findAll() {
        return activityLogService.findAll();
    }

    @GetMapping("/{id}")
    public ActivityLogDto findById(@PathVariable int id) {
        return activityLogService.findById(id);
    }

    @PostMapping()
    public ActivityLogDto post(@RequestBody ActivityLogDto c) {
        return activityLogService.add(c);
    }

    @PutMapping("/{id}")
    public boolean put(@PathVariable int id, @RequestBody ActivityLogDto c) {
        activityLogService.update(id, c);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        activityLogService.deleteById(id);
        return true;
    }

}
