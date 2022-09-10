package edu.miu.springdatademo.service.impl;

import edu.miu.springdatademo.dto.ProductDTO;
import edu.miu.springdatademo.dto.ReviewDTO;
import edu.miu.springdatademo.entity.Product;
import edu.miu.springdatademo.repo.ProductRepo;
import edu.miu.springdatademo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<ProductDTO> getAllProduct() {
        return productRepo.findAll().stream().map(all->modelMapper.map(all,ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Integer id) {
        return modelMapper.map(productRepo.findById(id).
                orElseThrow(()->new RuntimeException("Invalid Info about Id")),ProductDTO.class);
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        return modelMapper.map(productRepo.save(modelMapper.map(productDTO,Product.class)),ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Integer id) {
        Product product = modelMapper.map(productDTO, Product.class);
        product = productRepo.save(product);
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO deleteProduct(Integer id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID!"));
        productRepo.delete(product);
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getProductsByMinPrice(Integer minPrice) {
        List<Product> products = productRepo.findAllByPriceGreaterThan(minPrice);

        return products.stream().map(product -> modelMapper.map(product,ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findProductContainingKeyword(String keyword) {
        return  productRepo.findAllByNameContaining(keyword)
                .stream().map(pro -> modelMapper.map(pro, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> findReviewsOfProduct(Long id) {
        return null;
                //productRepo.findById(id).orElseThrow(()-> new RuntimeException("Incorrect ID")).getRating();
    }
}
