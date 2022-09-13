package edu.miu.day3springdata.controller;

import edu.miu.day3springdata.aspect.ExecutionTime;
import edu.miu.day3springdata.dto.ReviewDto;
import edu.miu.day3springdata.entity.Review;
import edu.miu.day3springdata.repo.ReviewRepository;
import edu.miu.day3springdata.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products/{id}/reviews")
public class ReviewController {
    private final ProductService productService;

    @ExecutionTime
    @GetMapping
    public List<ReviewDto> getReview(@PathVariable Integer id) {
        return productService.findProductsReviewByProductId(id);
    }

    @ExecutionTime
    @PostMapping
    public void saveReview(@PathVariable Integer id, @RequestBody ReviewDto review) {
        productService.saveProductReview(review, id);
    }

}
