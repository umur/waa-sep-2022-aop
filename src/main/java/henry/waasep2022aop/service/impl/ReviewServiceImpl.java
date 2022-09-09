package henry.waasep2022aop.service.impl;

import henry.waasep2022aop.dto.ReviewDto;
import henry.waasep2022aop.entity.Review;
import henry.waasep2022aop.mapper.ListMapper;
import henry.waasep2022aop.repo.ReviewRepo;
import henry.waasep2022aop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;
    @Override
    public void save(ReviewDto reviewDto) {
        reviewRepo.save(modelMapper.map(reviewDto, Review.class));
    }

    @Override
    public List<ReviewDto> findAll() {
        return listMapper.map((List<Review>)reviewRepo.findAll(), ReviewDto.class);
    }

    @Override
    public void update(int reviewId, ReviewDto reviewDto) {
        Review review = reviewRepo.findById(reviewId).orElse(null);
        if (review != null) {
            Review newReview = modelMapper.map(reviewDto, Review.class);
            newReview.setId(reviewId);
            reviewRepo.save(newReview);
        }
    }

    @Override
    public ReviewDto delete(int reviewId) {
        Review review = reviewRepo.findById(reviewId).orElse(null);
        reviewRepo.deleteById(reviewId);
        return review != null ? modelMapper.map(review, ReviewDto.class) : null;
    }
}
