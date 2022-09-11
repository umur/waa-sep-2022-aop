package WAA.spring.data.services;

import WAA.spring.data.entity.Address;
import WAA.spring.data.entity.Review;

import java.util.List;

public interface ReviewService {
    void save(Review review);
    Review getById(int id);
    void update(int id, Review reviewreq);
    void delete(int id);
    List<Review> findAll();
    public List<Review> findAllById(int Id);
}
