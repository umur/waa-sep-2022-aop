package henry.waasep2022aop.service;

import henry.waasep2022aop.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    void save(ReviewDto reviewDto);
    List<ReviewDto> findAll();
    void update(int reviewId, ReviewDto reviewDto);
    ReviewDto delete(int reviewId);
}
