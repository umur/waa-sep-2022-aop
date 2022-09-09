package edu.miu.lab5aop.service.impl;

import edu.miu.lab5aop.dto.CategoryDto;
import edu.miu.lab5aop.entity.Category;
import edu.miu.lab5aop.exception.NotFoundException;
import edu.miu.lab5aop.mapper.CategoryMapper;
import edu.miu.lab5aop.mapper.ProductMapper;
import edu.miu.lab5aop.repo.CategoryRepository;
import edu.miu.lab5aop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    private final ProductMapper productMapper;

    @Override
    public List<CategoryDto> getAll() {
        return categoryMapper.toDtos((List<Category>) categoryRepository.findAll());
    }

    @Override
    public CategoryDto getById(int id) {

        Optional<Category> category = categoryRepository.findById(id);
        return categoryMapper.toDto(category.get());
    }

    @Override
    @Transactional
    public void save(CategoryDto categoryDto) {
        categoryRepository.save(categoryMapper.toEntity(categoryDto));
    }


    @Override
    @Transactional
    public void delete(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cannot find category: " + id));
        categoryRepository.delete(category);
    }
}
