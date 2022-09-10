package edu.miu.springdatademo.controller;

import edu.miu.springdatademo.dto.ProductDTO;
import edu.miu.springdatademo.dto.ReviewDTO;
import edu.miu.springdatademo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO productDTO){
        return productService.saveProduct(productDTO);
    }

    @GetMapping
    public List<ProductDTO> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public ProductDTO findProductByID(@PathVariable Integer id){
        return productService.getProductById(id);
    }


    @GetMapping("/filter")
    public List<ProductDTO> getProductsByMinPrice(@RequestParam Integer minPrice){
        return productService.getProductsByMinPrice(minPrice);
    }

    @GetMapping("/keyword")
    public List<ProductDTO> findProductContainingKeyword(@RequestParam String keyword){
        return productService.findProductContainingKeyword(keyword);
    }

    @GetMapping("/{id}/reviews")
    public List<ReviewDTO> findReviewsOfProduct(@PathVariable Long id){
        return productService.findReviewsOfProduct(id);
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Integer id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct( productDTO,id);
    }

    @DeleteMapping("/{id}")
    public ProductDTO delete(@PathVariable Integer id){
        return productService.deleteProduct(id);



}}
