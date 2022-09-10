package com.example.dayThree.Service;

import com.example.dayThree.entity.Product;
import com.example.dayThree.entity.Review;
import com.example.dayThree.repo.CatagoryRepo;
import com.example.dayThree.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    @Autowired
    CatagoryRepo catagoryRepo;
    public List<Product> getListOfProduct() {
       return productRepo.findAll();
    }

    public Optional<Product> getProductById(long id) {
        return productRepo.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }


    public Optional<Product> deleteProduct(long id) {
        Optional<Product> product = getProductById(id);
        productRepo.deleteById(id);
        return product;
    }

    public List<Product> filterByPrice(long price) {
       return productRepo.findByPriceGreaterThan(price);
    }

    public List<Product> containKeyword(String keyword) {
        return productRepo.findByNameContaining(keyword);
    }

}
