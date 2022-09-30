package com.example.demo.service;

import com.example.demo.Entity.StudentEntity;
import com.example.demo.dto.StudentDto;
import com.example.demo.repository.StudentRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements   StudentService{
    @Autowired
    private StudentRep studentRep;
    @Override
    public void saveStudent(StudentDto studentDto) {

        StudentEntity student =new StudentEntity();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        studentRep.save(student);

    }
}
