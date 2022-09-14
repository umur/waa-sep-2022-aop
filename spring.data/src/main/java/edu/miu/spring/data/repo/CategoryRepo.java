package edu.miu.spring.data.repo;

import edu.miu.spring.data.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Integer> {
}
