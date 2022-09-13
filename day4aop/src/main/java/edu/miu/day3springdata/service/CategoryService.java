package edu.miu.day3springdata.service;

import edu.miu.day3springdata.dto.CategoryDto;
import edu.miu.day3springdata.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();

    void save(CategoryDto c);

    CategoryDto getCategory(Integer categoryId);
}
