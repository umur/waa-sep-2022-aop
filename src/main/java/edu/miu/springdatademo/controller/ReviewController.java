package edu.miu.springdatademo.controller;

import edu.miu.springdatademo.dto.AddressDTO;
import edu.miu.springdatademo.dto.ReviewDTO;
import edu.miu.springdatademo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Reviews")
public class ReviewController {


        private final ReviewService reviewService;

        @PostMapping
        public ReviewDTO save(@RequestBody ReviewDTO reviewDTO){
            return reviewService.SaveReview(reviewDTO);
        }

        @GetMapping
        public List<ReviewDTO> findAll(){
            return reviewService.getAllReview();
        }

        @GetMapping("/{id}")
        public  ReviewDTO find(@PathVariable Integer id){
            return reviewService.getReviewById(id);
        }

        @PutMapping("/{id}")
        public ReviewDTO update(@PathVariable Integer id, @RequestBody ReviewDTO reviewDTO){
            return reviewService.updateReview(reviewDTO,id);
        }}


