package com.example.lab3final.Lab3finalApplication.controller;

import com.example.lab3final.Lab3finalApplication.entity.bidirectional.Product;
import com.example.lab3final.Lab3finalApplication.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("labs/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public void save(@RequestBody Product p){
        productService.save(p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public  void update(@PathVariable int id, @RequestBody Product p){
        productService.update(id,p);
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id){
        return productService.getById(id);
    }

    @GetMapping("/filter-by-name")
    public List<Product> findByName(@RequestParam String name){
        return productService.findByName(name);
    }

    @GetMapping("/filter-by-price-gt")
    public List<Product> findByCostGreaterThan(@RequestParam double price){
        return productService.findByCostGreaterThan(price);
    }

    @GetMapping("/{cid}/filter-by-price-lt")
    public List<Product> findByCategoryAndPriceLT(@PathVariable int cid,@RequestParam double price){
        return productService.findByCategoryIdAndPriceLessThan(cid, price);
    }

    @GetMapping("/find-by-user-review/{uid}")
    public List<Product> getProductsReviewedBy(@PathVariable int uid){
        return productService.findAllReviewedByUser(uid);
    }












}
