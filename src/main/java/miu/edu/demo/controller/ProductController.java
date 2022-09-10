package miu.edu.demo.controller;

import miu.edu.demo.aspect.annotation.Executiontime;
import miu.edu.demo.dto.ProductDTO;
import miu.edu.demo.entity.Product;
import miu.edu.demo.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;
    @GetMapping
    @Executiontime
    public List<ProductDTO> getAllProduct(){
      return productService.getAllProducts();
    }
    @PostMapping
    public void save(ProductDTO product){
        System.out.println(product);
        productService.saveProduct(product);
    }
}
