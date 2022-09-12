package com.aop.springaop.Repository;

import com.aop.springaop.Model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends CrudRepository<Course,Integer> {
}
