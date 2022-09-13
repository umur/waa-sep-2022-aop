package edu.miu.day3springdata.repo;

import edu.miu.day3springdata.entity.Review;
import edu.miu.day3springdata.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
