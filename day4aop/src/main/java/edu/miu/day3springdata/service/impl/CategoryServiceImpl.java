package edu.miu.day3springdata.service.impl;

import edu.miu.day3springdata.dto.CategoryDto;
import edu.miu.day3springdata.entity.Category;
import edu.miu.day3springdata.repo.CategoryRepository;
import edu.miu.day3springdata.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final ModelMapper modelMapper;

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categories = new ArrayList<>();
        for (Category category : categoryRepository.findAll()) {
            CategoryDto c = modelMapper.map(category, CategoryDto.class);
            categories.add(c);
        }
        return categories;
    }

    @Override
    public void save(CategoryDto c) {
        Category category = modelMapper.map(c, Category.class);

        categoryRepository.save(category);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).get();
        return modelMapper.map(category, CategoryDto.class);
    }


}
