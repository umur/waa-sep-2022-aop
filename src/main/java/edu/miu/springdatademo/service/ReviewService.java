package edu.miu.springdatademo.service;

import edu.miu.springdatademo.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    //Read
    public List<ReviewDTO> getAllReview();
    public ReviewDTO getReviewById(Integer id);
    //Create
    public ReviewDTO SaveReview(ReviewDTO reviewDTO);

    //Update
    public ReviewDTO updateReview(ReviewDTO reviewDTO, Integer id);

    //delete
    public ReviewDTO deleteReview(Integer id);
}
