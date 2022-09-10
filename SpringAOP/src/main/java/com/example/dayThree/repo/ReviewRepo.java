package com.example.dayThree.repo;

import com.example.dayThree.entity.Product;
import com.example.dayThree.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
}
