package edu.miu.day3springdata.repo;

import edu.miu.day3springdata.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("select min(p.price) from Product p")
    public double getMinPrice();

    @Query("select max(p.price) from Product p")
    public double getMaxPrice();


    public List<Product> findProductByPriceGreaterThan(double minPrice);


    public List<Product> findProductByPriceLessThanAndCategory_NameIgnoreCase(double maxPrice, String category);

    public List<Product> findProductByNameContaining(String name);



}
