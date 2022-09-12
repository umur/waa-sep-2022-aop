package com.aop.springaop.Service;

import com.aop.springaop.Model.Professor;
import com.aop.springaop.Model.Student;

import java.util.List;

public interface ProfessorService {
    public List<Professor> findAll();
    public Professor findById(int id);
    public Professor addProfessor(Professor professor);
    public Professor updateProfessor(Professor professor);
    public void deleteProfessorById(int id);
}
