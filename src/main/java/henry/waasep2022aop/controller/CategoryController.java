package henry.waasep2022aop.controller;

import henry.waasep2022aop.aspect.annotation.ExecutionTime;
import henry.waasep2022aop.dto.CategoryDto;
import henry.waasep2022aop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @ExecutionTime
    @PostMapping
    public void save(@RequestBody CategoryDto categoryDto) {
        categoryService.save(categoryDto);
    }

    @ExecutionTime
    @GetMapping
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @ExecutionTime
    @PutMapping("/{categoryId}")
    public void update(@PathVariable int categoryId, @RequestBody CategoryDto categoryDto) {
        categoryService.update(categoryId, categoryDto);
    }

    @ExecutionTime
    @DeleteMapping("/{categoryId}")
    public CategoryDto delete(@PathVariable int categoryId) {
        return categoryService.delete(categoryId);
    }
}
