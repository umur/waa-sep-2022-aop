package com.example.lab3final.Lab3finalApplication.repo;

import com.example.lab3final.Lab3finalApplication.entity.bidirectional.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Integer> {
}
