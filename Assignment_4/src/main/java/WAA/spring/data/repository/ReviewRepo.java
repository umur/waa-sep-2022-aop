package WAA.spring.data.repository;

import WAA.spring.data.entity.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepo extends CrudRepository<Review,Integer> {
      public List<Review> findAllById(int Id);
}
