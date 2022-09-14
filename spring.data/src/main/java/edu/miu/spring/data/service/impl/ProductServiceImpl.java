package edu.miu.spring.data.service.impl;

import edu.miu.spring.data.entity.Category;
import edu.miu.spring.data.entity.Product;
import edu.miu.spring.data.repo.ProductRepo;
import edu.miu.spring.data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;
    @Override
    public void save(Product product) {

        productRepo.save(product);
    }

    @Override
    public Product getById(int id) {

        return productRepo.findById(id).orElse(null);
    }

    @Override
    public void update(int id, Product productReq) {
        Product product= productRepo.findById(id).orElse(null);
        if(product==null)
            throw new NullPointerException("Id is not valid");

        product.setName(productReq.getName());
        product.setPrice(productReq.getPrice());
        product.setCategory(productReq.getCategory());
        product.setRating(productReq.getRating());

        productRepo.save(product);
    }
    @Override
    public void delete(int id){
        Product product=productRepo.findById(id).orElse(null);
        if(product==null)
            throw new NullPointerException("Id is not valid");

        productRepo.delete(product);

    }
    @Override
    public List<Product> findAll(){

        return (List<Product>) productRepo.findAll();
    }
    @Override
    public List<Product> findAllByPriceGreaterThan(int minPrice){
        return productRepo.findByPriceGreaterThan(minPrice);
    }
    @Override
    public List<Product> findAllCategoryAndPriceLessThan(Category cat, int maxPrice){
        return productRepo.findByCategoryAndPriceLessThan(cat,maxPrice);
    }
    @Override
    public List<Product> findAllByNameContaining(String keyword){

        return productRepo.findByNameContaining(keyword);
    }
}
