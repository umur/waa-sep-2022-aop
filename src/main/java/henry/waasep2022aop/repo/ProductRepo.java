package henry.waasep2022aop.repo;

import henry.waasep2022aop.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    List<Product> findProductsByPriceGreaterThan(double minPrice);
    List<Product> findProductsByNameContains(String keyword);
    List<Product> findProductsByCategory_IdAndPriceLessThan(int categoryId, double maxPrice);
}
