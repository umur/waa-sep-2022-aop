package com.example.dayThree.Service;

import com.example.dayThree.entity.Address;
import com.example.dayThree.entity.Category;
import com.example.dayThree.entity.Product;
import com.example.dayThree.repo.CatagoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatagoryService {
    @Autowired
    CatagoryRepo catagoryRepo;
    public List<Category> allCatagory() {
        return catagoryRepo.findAll();
    }

    public Optional<Category> getCatagoryById(long id) {
        return catagoryRepo.findById(id);
    }

    public List<Product> findProductLessThanPrice(String categoryName, long price) {
        return catagoryRepo.findProductLessThanPrice(categoryName, price);
    }
}
