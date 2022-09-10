package edu.miu.springdatademo.controller;

import edu.miu.springdatademo.dto.CategoryDTO;
import edu.miu.springdatademo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")

public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryDTO save(@RequestBody CategoryDTO categoryDTO){
        return categoryService.SaveCategory(categoryDTO);
    }

    @GetMapping
    public List<CategoryDTO> findAll(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public  CategoryDTO find(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable Integer id, @RequestBody CategoryDTO categoryDTO){
        return categoryService.updateCategory(categoryDTO,id);
    }


    }

