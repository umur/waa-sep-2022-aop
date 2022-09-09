package edu.miu.lab5aop.repo;

import edu.miu.lab5aop.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findProductsByPriceGreaterThanEqual(Double minPrice);

    List<Product> findProductsByCategory_IdAndPriceLessThanEqual(int id, Double maxPrice);
}
