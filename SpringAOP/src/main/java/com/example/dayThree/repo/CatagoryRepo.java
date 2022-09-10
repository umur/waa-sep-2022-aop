package com.example.dayThree.repo;

import com.example.dayThree.entity.Category;
import com.example.dayThree.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatagoryRepo extends JpaRepository<Category, Long> {

    @Query(value = "select p from Product p where p.price < :price and p.category.name = :categoryName")
    List<Product> findProductLessThanPrice(String categoryName, long price);
}
