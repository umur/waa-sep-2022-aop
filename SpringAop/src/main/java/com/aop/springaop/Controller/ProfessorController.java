package com.aop.springaop.Controller;

import com.aop.springaop.Model.Professor;
import com.aop.springaop.Service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {
    private ProfessorService professorService;
    public ProfessorController(ProfessorService professorService){
        this.professorService=professorService;
    }
    @GetMapping
    public List<Professor> findAll() {
        return professorService.findAll();
    }

    @GetMapping("/{id}")
    public Professor findById(@PathVariable int id) {
        return professorService.findById(id);
    }

    @PostMapping
    public Professor addProfessor(Professor professor) {
        return professorService.addProfessor(professor);
    }

    @PutMapping
    public Professor updateProfessor(Professor professor) {
        return professorService.updateProfessor(professor);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessorById(@PathVariable int id) {
        professorService.deleteProfessorById(id);
    }
}
