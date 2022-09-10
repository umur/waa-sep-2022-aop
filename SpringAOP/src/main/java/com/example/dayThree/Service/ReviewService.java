package com.example.dayThree.Service;

import com.example.dayThree.entity.Product;
import com.example.dayThree.entity.Review;
import com.example.dayThree.repo.ProductRepo;
import com.example.dayThree.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewRepo reviewRepo;
    public List<Review> getReviewList() {
       return reviewRepo.findAll();
    }
}
