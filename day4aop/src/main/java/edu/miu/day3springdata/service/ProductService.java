package edu.miu.day3springdata.service;

import edu.miu.day3springdata.dto.ProductDto;
import edu.miu.day3springdata.dto.ReviewDto;

import java.util.List;

public interface ProductService {
    void save(ProductDto p);

    void update(ProductDto p, Integer id);

    ProductDto findById(Integer id);

    void deleteById(Integer id);

    List<ProductDto> getAllProducts();

    List<ProductDto> findAllProductsGreaterThenMinPrice();

    List<ProductDto> findAllProductsByCategoryAndLessThanMaxPrice(String category);

    List<ProductDto> findProductsCotainsName(String name);

    List<ReviewDto> findProductsReviewByProductId(Integer id);

    void saveProductReview(ReviewDto reviewDto, Integer productId);
}
