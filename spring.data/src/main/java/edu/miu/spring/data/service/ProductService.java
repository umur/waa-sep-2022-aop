package edu.miu.spring.data.service;

import edu.miu.spring.data.entity.Category;
import edu.miu.spring.data.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    Product getById(int id);

    void update(int id, Product productReq);

    void delete(int id);

    List<Product> findAll();

    List<Product> findAllByPriceGreaterThan(int minPrice);

    List<Product> findAllCategoryAndPriceLessThan(Category cat, int maxPrice);

    List<Product> findAllByNameContaining(String keyword);
}
