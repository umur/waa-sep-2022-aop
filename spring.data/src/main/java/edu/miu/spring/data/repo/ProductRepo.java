package edu.miu.spring.data.repo;

import edu.miu.spring.data.entity.Category;
import edu.miu.spring.data.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {

    public List<Product> findByPriceGreaterThan(int minPrice);
    public List<Product> findByCategoryAndPriceLessThan(Category category, double maxPrice);
    public List<Product> findByNameContaining(String keyword);


}
