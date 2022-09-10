package com.example.day5.Service;

import com.example.day5.entity.Student;

import java.util.List;

public interface StudentService {

    public void save(Student student);

    public List<Student> findAll();

    public void delete(int id);

    public void update(Student student);
}
