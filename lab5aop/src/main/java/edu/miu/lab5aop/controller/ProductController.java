package edu.miu.lab5aop.controller;

import edu.miu.lab5aop.dto.ProductDto;
import edu.miu.lab5aop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @PostMapping("/category/{id}")
    public void add(@PathVariable int id, @RequestBody ProductDto productDto) {
        productService.add(id, productDto);
    }

    @GetMapping("/search")
    public List<ProductDto> find(@RequestParam("min-price") Double minPrice) {
        return productService.findByPrice(minPrice);
    }

    @GetMapping("/category/{id}/search")
    public List<ProductDto> find(@PathVariable int id, @RequestParam("max-price") Double maxPrice) {
        return productService.findByCategoryAndMaxPrice(id, maxPrice);
    }
}
