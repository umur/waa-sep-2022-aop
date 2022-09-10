package edu.miu.springdatademo.service.impl;

import edu.miu.springdatademo.dto.AddressDTO;
import edu.miu.springdatademo.dto.CategoryDTO;

import edu.miu.springdatademo.entity.Category;
import edu.miu.springdatademo.repo.CategoryRepo;
import edu.miu.springdatademo.service.AddressService;
import edu.miu.springdatademo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    public CategoryRepo categoryRepo;
    @Autowired
    public ModelMapper modelMapper;

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categories =categoryRepo.findAll();
        return categories.stream().map(category -> modelMapper.map(category,CategoryDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Integer id) {

        return modelMapper.map(categoryRepo.findById(id).orElseThrow(()->new RuntimeException("invalid input")), CategoryDTO.class);
    }

    @Override
    public CategoryDTO SaveCategory(CategoryDTO categoryDTO) {
        Category category=modelMapper.map(categoryDTO, Category.class);
        category=categoryRepo.save(category);
        return modelMapper.map(category,CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer id) {
        if(id!=categoryDTO.getId()) throw new RuntimeException("not found");
        Category category=modelMapper.map(categoryDTO,Category.class);
        category=categoryRepo.save(category);
        return modelMapper.map(category,CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory(Integer id) {
        Category category=categoryRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
        categoryRepo.delete(category);
        return modelMapper.map(category,CategoryDTO.class);
    }
}
