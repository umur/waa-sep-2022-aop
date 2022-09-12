package com.aop.springaop.Service;

import com.aop.springaop.Model.Course;
import com.aop.springaop.Model.Professor;
import com.aop.springaop.Model.Student;

import java.util.List;

public interface CourseService {
    public List<Course> findAll();
    public Course findById(int id);
    public Course addCourse(Course student);
    public Course updateCourse(Course student);
    public void deleteCourseById(int id);
}
