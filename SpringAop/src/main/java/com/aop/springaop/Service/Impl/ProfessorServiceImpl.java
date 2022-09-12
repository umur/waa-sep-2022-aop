package com.aop.springaop.Service.Impl;

import com.aop.springaop.Model.Professor;
import com.aop.springaop.Repository.ProfessorRepo;
import com.aop.springaop.Service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepo professorRepo;

    public ProfessorServiceImpl(ProfessorRepo professorRepo){
        this.professorRepo=professorRepo;
    }

    @Override
    public List<Professor> findAll() {
        return (List<Professor>) professorRepo.findAll();
    }

    @Override
    public Professor findById(int id) {
       if(professorRepo.findById(id).isPresent()){
           professorRepo.findById(id);
       }
       return null;
    }

    @Override
    public Professor addProfessor(Professor professor) {
        return professorRepo.save(professor);
    }

    @Override
    public Professor updateProfessor(Professor professor) {
        return professorRepo.save(professor);
    }

    @Override
    public void deleteProfessorById(int id) {
         professorRepo.deleteById(id);
    }
}
