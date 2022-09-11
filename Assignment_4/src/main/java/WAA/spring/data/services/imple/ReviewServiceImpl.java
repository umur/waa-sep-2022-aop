package WAA.spring.data.services.imple;

import WAA.spring.data.entity.Review;
import WAA.spring.data.repository.ProductRepo;
import WAA.spring.data.repository.ReviewRepo;
import WAA.spring.data.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;

    @Override
    public void save(Review review) {

    }

    @Override
    public Review getById(int id) {
        return null;
    }

    @Override
    public void update(int id, Review reviewreq) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Review> findAll() {
        return null;
    }

    @Override
    public List<Review> findAllById(int id) {
        return reviewRepo.findAllById(id);
    }
}
