package com.example.dayThree.controller;

import com.example.dayThree.Service.ProductService;
import com.example.dayThree.Service.ReviewService;
import com.example.dayThree.entity.Product;
import com.example.dayThree.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    public List<Review> getReviewList(){
        return reviewService.getReviewList();
    }
}
