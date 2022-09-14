package edu.miu.spring.data.service;

import edu.miu.spring.data.entity.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    Category getById(int id);
    void update(int id, Category categoryReq);
    void delete(int id);
    List<Category> findAll();
}
