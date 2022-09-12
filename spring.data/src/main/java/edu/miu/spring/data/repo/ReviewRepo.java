package edu.miu.spring.data.repo;

import edu.miu.spring.data.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {

    public List<Review> findAllById(int id);
}
