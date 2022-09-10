package edu.miu.lab4.service.impl;

import edu.miu.lab4.aspect.annotation.ExecutionTime;
import edu.miu.lab4.aspect.annotation.ExistedAopHeader;
import edu.miu.lab4.dto.CategoryDto;
import edu.miu.lab4.entity.Category;
import edu.miu.lab4.repo.CategoryRepo;
import edu.miu.lab4.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepo categoryRepo, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }

    @ExecutionTime
    @ExistedAopHeader
    @Override
    public List<CategoryDto> findAll() {
        return ((List<Category>) categoryRepo.findAll()).stream().map(p -> modelMapper.map(p, CategoryDto.class)).toList();
    }

    @Override
    public CategoryDto findById(int id) {
        Category category = categoryRepo.findById(id).orElse(null);
        return category == null ? null : modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public CategoryDto add(CategoryDto category) {
        Category c = modelMapper.map(category, Category.class);
        Category saved = categoryRepo.save(c);
        return modelMapper.map(saved, CategoryDto.class);
    }

    @Override
    public void update(int id, CategoryDto category) {
        Category c = modelMapper.map(category, Category.class);
        categoryRepo.save(c);
    }

    @Override
    public void deleteById(int id) {
        categoryRepo.deleteById(id);
    }

}
