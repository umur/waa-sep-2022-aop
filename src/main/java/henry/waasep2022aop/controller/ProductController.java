package henry.waasep2022aop.controller;

import henry.waasep2022aop.aspect.annotation.ExecutionTime;
import henry.waasep2022aop.dto.ProductDto;
import henry.waasep2022aop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @ExecutionTime
    @PostMapping
    public void save(@RequestBody ProductDto productDto) {
        productService.save(productDto);
    }

    @ExecutionTime
    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @ExecutionTime
    @PutMapping("/{productId}")
    public void update(@PathVariable int productId, @RequestBody ProductDto productDto) {
        productService.update(productId, productDto);
    }

    @ExecutionTime
    @DeleteMapping("/{productId}")
    public ProductDto delete(@PathVariable int productId) {
        return productService.delete(productId);
    }

    @ExecutionTime
    @GetMapping("/search/min-price/{price}")
    public List<ProductDto> searchByMinPrice(@PathVariable double price) {
        return productService.findWithMinPrice(price);
    }

    @ExecutionTime
    @GetMapping("/search/name/{keyword}")
    public List<ProductDto> searchByName(@PathVariable String keyword) {
        return productService.findWithName(keyword);
    }

    @ExecutionTime
    @GetMapping("/search/category-and-max-price/{categoryId}/{price}")
    public List<ProductDto> searchByCategoryAndMaxPrice(@PathVariable int categoryId, @PathVariable double price) {
        return productService.findWithCategoryAndMaxPrice(categoryId, price);
    }
}
