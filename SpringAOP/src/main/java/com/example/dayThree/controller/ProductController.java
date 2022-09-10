package com.example.dayThree.controller;

import com.example.dayThree.Service.ProductService;
import com.example.dayThree.entity.Category;
import com.example.dayThree.entity.Product;
import com.example.dayThree.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> productList(){
        return productService.getListOfProduct();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public Optional<Product> deleteProduct(@PathVariable long id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/price")
    public List<Product> filterByPrice(@RequestParam long price){
       return productService.filterByPrice(price);
    }

    @GetMapping("/keyword")
    public List<Product> filterByPrice(@RequestParam String keyword){
       return productService.containKeyword(keyword);

    }

}
