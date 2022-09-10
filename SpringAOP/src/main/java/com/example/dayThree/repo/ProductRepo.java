package com.example.dayThree.repo;

import com.example.dayThree.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findByPriceGreaterThan(long price);

    //for similar query
//    @Query("select p from Product p where p.name LIKE :keyword")
    List<Product> findByNameContaining(String keyword);
}
