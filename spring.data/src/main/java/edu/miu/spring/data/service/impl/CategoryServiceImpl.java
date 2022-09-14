package edu.miu.spring.data.service.impl;

import edu.miu.spring.data.entity.Category;
import edu.miu.spring.data.repo.CategoryRepo;
import edu.miu.spring.data.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public void save(Category category){
        categoryRepo.save(category);
    }
    @Override
    public Category getById(int id){
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public void update(int id, Category categoryReq) {
        Category category =categoryRepo.findById(id).orElse(null);
        if(category==null)
            throw new NullPointerException("the Id is not exist in DB");
        category.setName(categoryReq.getName());
    }

    @Override
    public void delete(int id) {
        Category category =categoryRepo.findById(id).orElse(null);
        categoryRepo.delete(category);

    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepo.findAll();
    }

}
