package com.example.dayThree.controller;

import com.example.dayThree.Service.CatagoryService;
import com.example.dayThree.entity.Address;
import com.example.dayThree.entity.Category;
import com.example.dayThree.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/catagory")
public class CatagoryController {
    @Autowired
    CatagoryService catagoryService;

    @GetMapping
    public List<Category> listOfCatagory(){
       return catagoryService.allCatagory();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCatagoryById(@PathVariable long id){
        return catagoryService.getCatagoryById(id);
    }


    @GetMapping("/filter")
    public List<Product> listOfProductLessThanPrice(@RequestParam String categoryName, @RequestParam long price){
       return catagoryService.findProductLessThanPrice(categoryName, price);
    }
}
