package com.aop.springaop.Service;

import com.aop.springaop.Model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public Student findById(int id);
    public Student addStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudentById(int id);
}
