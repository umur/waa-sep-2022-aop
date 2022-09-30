package com.example.demo.repository;

import com.example.demo.Entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRep extends CrudRepository<StudentEntity,Integer> {
}
