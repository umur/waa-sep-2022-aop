package edu.miu.lab5aop.controller;

import edu.miu.lab5aop.aspect.annotation.ExecutionTime;
import edu.miu.lab5aop.dto.CategoryDto;
import edu.miu.lab5aop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @ExecutionTime
    public List<CategoryDto> getCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getById(@PathVariable int id) {
        return categoryService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody CategoryDto categoryDto) {
        categoryService.save(categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }
}
