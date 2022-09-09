package henry.waasep2022aop.controller;

import henry.waasep2022aop.aspect.annotation.ExecutionTime;
import henry.waasep2022aop.dto.ReviewDto;
import henry.waasep2022aop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @ExecutionTime
    @PostMapping
    public void save(@RequestBody ReviewDto reviewDto) {
        reviewService.save(reviewDto);
    }

    @ExecutionTime
    @GetMapping
    public List<ReviewDto> findAll() {
        return reviewService.findAll();
    }

    @ExecutionTime
    @PutMapping("/{reviewId}")
    public void update(@PathVariable int reviewId, @RequestBody ReviewDto reviewDto) {
        reviewService.update(reviewId, reviewDto);
    }

    @ExecutionTime
    @DeleteMapping("/{reviewId}")
    public ReviewDto delete(@PathVariable int reviewId) {
        return reviewService.delete(reviewId);
    }
}
