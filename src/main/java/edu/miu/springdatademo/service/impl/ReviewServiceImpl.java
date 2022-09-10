package edu.miu.springdatademo.service.impl;

import edu.miu.springdatademo.dto.ReviewDTO;
import edu.miu.springdatademo.entity.Review;
import edu.miu.springdatademo.repo.ReviewRepo;
import edu.miu.springdatademo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;
@Autowired
    private ModelMapper modelMapper;


    @Override
    public List<ReviewDTO> getAllReview() {
        return reviewRepo.findAll().stream().map(all->modelMapper.map(all,ReviewDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ReviewDTO getReviewById(Integer id) {
        return modelMapper.map(reviewRepo.findById(id).orElseThrow(()->new RuntimeException("Incorrect ID")),ReviewDTO.class);
    }

    @Override
    public ReviewDTO SaveReview(ReviewDTO reviewDTO) {
       return modelMapper.map(reviewRepo.save(modelMapper.map(reviewDTO, Review.class)), ReviewDTO.class);
    }

    @Override
    public ReviewDTO updateReview(ReviewDTO reviewDTO, Integer id) {
        Review review = modelMapper.map(reviewDTO,Review.class);
        review=reviewRepo.save(review);
        return modelMapper.map(review,ReviewDTO.class);
    }

    @Override
    public ReviewDTO deleteReview(Integer id) {
        Review review = reviewRepo.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID!"));
        reviewRepo.delete(review);
        return modelMapper.map(review, ReviewDTO.class);
    }
}
