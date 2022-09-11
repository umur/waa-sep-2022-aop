package WAA.spring.data.repository;

import WAA.spring.data.entity.Category;
import WAA.spring.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    public List<Product> findAllByPriceGreaterThan(double minPrice);
    public List<Product> findAllByCategoryAndPriceLessThan(Category cat, double maxPrice);
    public List<Product> findAllByNameContaining(String keyword);
}
