package edu.miu.day3springdata.controller;

import edu.miu.day3springdata.aspect.ExecutionTime;
import edu.miu.day3springdata.dto.CategoryDto;
import edu.miu.day3springdata.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategory(@PathVariable Integer id) {
        return categoryService.getCategory(id);
    }

    @ExecutionTime
    @PostMapping
    public void saveCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.save(categoryDto);
    }

}
