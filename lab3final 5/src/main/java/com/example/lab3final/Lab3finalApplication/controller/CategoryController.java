package com.example.lab3final.Lab3finalApplication.controller;

import com.example.lab3final.Lab3finalApplication.entity.bidirectional.Category;
import com.example.lab3final.Lab3finalApplication.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("labs/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping
    public void save(@RequestBody Category a){
        categoryService.save(a);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        categoryService.delete(id);
    }

    @PutMapping("/{id}")
    public  void update(@PathVariable int id, @RequestBody Category p){
        categoryService.update(id,p);
    }

    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable int id){
        return categoryService.getById(id);
    }

}
