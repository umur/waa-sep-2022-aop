package miu.edu.demo.repository;

import miu.edu.demo.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {
}
