package edu.miu.springdatademo.repo;

import edu.miu.springdatademo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

List<Product> findAllByPriceGreaterThan(Integer minPrice);
List<Product> findAllByNameContaining(String keyword);


}
