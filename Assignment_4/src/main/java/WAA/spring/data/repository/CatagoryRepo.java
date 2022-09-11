package WAA.spring.data.repository;

import WAA.spring.data.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatagoryRepo extends CrudRepository<Category,Integer> {

}
