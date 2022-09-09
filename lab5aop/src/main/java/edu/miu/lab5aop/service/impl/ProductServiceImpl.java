package edu.miu.lab5aop.service.impl;

import edu.miu.lab5aop.aspect.annotation.ExecutionTime;
import edu.miu.lab5aop.dto.ProductDto;
import edu.miu.lab5aop.entity.Category;
import edu.miu.lab5aop.entity.Product;
import edu.miu.lab5aop.exception.NotFoundException;
import edu.miu.lab5aop.mapper.ProductMapper;
import edu.miu.lab5aop.repo.CategoryRepository;
import edu.miu.lab5aop.repo.ProductRepository;
import edu.miu.lab5aop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    @Override
    @ExecutionTime
    public List<ProductDto> getProducts() {
        return productMapper.toDtos((List<Product>) productRepository.findAll());
    }

    @Transactional
    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Transactional
    @Override
    @ExecutionTime
    public void add(int categoryId, ProductDto productDto) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Cannot find category: " + categoryId));
        Product product = productMapper.toEntity(productDto);
        product.setCategory(category);
        productRepository.save(product);
    }

    @Override
    @ExecutionTime
    public List<ProductDto> findByPrice(Double minPrice) {
        return productMapper.toDtos(productRepository.findProductsByPriceGreaterThanEqual(minPrice));
    }

    @Override
    @ExecutionTime
    public List<ProductDto> findByCategoryAndMaxPrice(int categoryId, Double maxPrice) {
        return productMapper.toDtos(productRepository.findProductsByCategory_IdAndPriceLessThanEqual(categoryId, maxPrice));
    }
}
