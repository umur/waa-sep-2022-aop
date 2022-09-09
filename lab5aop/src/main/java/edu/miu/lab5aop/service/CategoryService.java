package edu.miu.lab5aop.service;

import edu.miu.lab5aop.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAll();

    CategoryDto getById(int id);

    void save(CategoryDto categoryDto);

    void delete(int id);
}
