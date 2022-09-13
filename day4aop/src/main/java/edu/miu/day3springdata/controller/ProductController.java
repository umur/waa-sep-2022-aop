package edu.miu.day3springdata.controller;

import edu.miu.day3springdata.aspect.ExecutionTime;
import edu.miu.day3springdata.dto.ProductDto;
import edu.miu.day3springdata.dto.ReviewDto;
import edu.miu.day3springdata.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @ExecutionTime
    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @ExecutionTime
    @PostMapping
    public void saveProduct(@RequestBody ProductDto p) {
        this.productService.save(p);
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Integer id) {
        return this.productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        this.productService.deleteById(id);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDto p, @PathVariable Integer id) {
        this.productService.update(p, id);
    }

    @GetMapping("/min-price")
    public List<ProductDto> findAllProductsMoreThanMinPrice() {
        return productService.findAllProductsGreaterThenMinPrice();
    }

    @GetMapping("/category/{category_name}")
    public List<ProductDto> findProductsWithCategoryAndLessThanMaxPrice(@PathVariable String category_name) {
        return productService.findAllProductsByCategoryAndLessThanMaxPrice(category_name);
    }

    @GetMapping("/filter")
    public List<ProductDto> findProductsCotainsName(@RequestParam String name) {
        return productService.findProductsCotainsName(name);
    }
}