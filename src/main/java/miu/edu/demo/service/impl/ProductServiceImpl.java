package miu.edu.demo.service.impl;

import miu.edu.demo.dto.ProductDTO;
import miu.edu.demo.entity.Product;
import miu.edu.demo.repository.ProductRepo;
import miu.edu.demo.service.ActivityLogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ActivityLogService {

    @Autowired
    ProductRepo productRepo;
    @Autowired
    ModelMapper modelMapper;
    public List<ProductDTO> getAllProducts() {
        List<Product> products = (List<Product>) productRepo.findAll();
        return products.stream().map(product -> modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());
    }

    public void saveProduct(ProductDTO product) {
        productRepo.save(modelMapper.map(product, Product.class));
    }
}
