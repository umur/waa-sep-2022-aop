package com.aop.springaop.Controller;

import com.aop.springaop.Model.Course;
import com.aop.springaop.Service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private CourseService courseService;
    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }
    @GetMapping
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable int id) {
        return  courseService.findById(id);
    }

    @PostMapping
    public Course addCourse(Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping
    public Course updateCourse(Course student) {
        return courseService.updateCourse(student);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable int id) {
        courseService.deleteCourseById(id);
    }

}
