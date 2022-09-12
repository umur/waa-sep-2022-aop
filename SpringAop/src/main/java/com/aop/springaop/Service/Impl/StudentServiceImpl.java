package com.aop.springaop.Service.Impl;

import com.aop.springaop.Model.Student;
import com.aop.springaop.Repository.StudentRepo;
import com.aop.springaop.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepo studentRepo;
    public StudentServiceImpl (StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }
    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public Student findById(int id) {
        if(studentRepo.findById(id).isPresent()){
           return studentRepo.findById(id).get();
        }
        return null;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void deleteStudentById(int id) {
         studentRepo.deleteById(id);
    }
}
