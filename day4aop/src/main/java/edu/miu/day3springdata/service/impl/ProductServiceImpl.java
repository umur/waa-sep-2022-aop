package edu.miu.day3springdata.service.impl;

import edu.miu.day3springdata.dto.ProductDto;
import edu.miu.day3springdata.dto.ReviewDto;
import edu.miu.day3springdata.entity.Product;
import edu.miu.day3springdata.entity.Review;
import edu.miu.day3springdata.repo.ProductRepository;
import edu.miu.day3springdata.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    @Override
    public void save(ProductDto p) {
        Product product = modelMapper.map(p, Product.class);
        productRepository.save(product);
    }

    @Override
    public void update(ProductDto p, Integer id) {
        Product product = modelMapper.map(p, Product.class);
        productRepository.save(product);
    }

    @Override
    public ProductDto findById(Integer id) {
        Product p = productRepository.findById(id).get();

        return modelMapper.map(p, ProductDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtos = new ArrayList<>();
        var data= productRepository.findAll();
        var iterator = data.iterator();
        while (iterator.hasNext()) {
            var p = iterator.next();
            

            var productDto = modelMapper.map(p, ProductDto.class);
            System.out.println(productDto.getCategory().getName());
            productDtos.add(productDto);
            System.out.println(productDtos.size());

        }
        return productDtos;
    }

    @Override
    public List<ProductDto> findAllProductsGreaterThenMinPrice() {
        double minPrice = productRepository.getMinPrice();

        List<Product> products =  productRepository.findProductByPriceGreaterThan(minPrice);
        return products.stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findAllProductsByCategoryAndLessThanMaxPrice(String category) {
        double maxPrice = productRepository.getMaxPrice();

        List<Product> products = productRepository.findProductByPriceLessThanAndCategory_NameIgnoreCase(maxPrice, category);

        return products.stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findProductsCotainsName(String name) {
        List<Product> products = productRepository.findProductByNameContaining(name);

        return products.stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDto> findProductsReviewByProductId(Integer id) {
        Product p = productRepository.findById(id).get();
        List<ReviewDto> reviewDtos = new ArrayList<>();
        reviewDtos = p.getReviews().stream().map(r -> modelMapper.map(r, ReviewDto.class)).collect(Collectors.toList());
        return reviewDtos;
    }

    @Override
    public void saveProductReview(ReviewDto reviewDto, Integer productId) {
        System.out.println(reviewDto);
        Review review = modelMapper.map(reviewDto, Review.class);
        System.out.println(review);

        Product p = productRepository.findById(productId).get();


        p.getReviews().add(review);

        productRepository.save(p);

    }
}
