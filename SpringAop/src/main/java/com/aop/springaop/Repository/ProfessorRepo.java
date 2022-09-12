package com.aop.springaop.Repository;

import com.aop.springaop.Model.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepo extends CrudRepository<Professor,Integer> {
}
