package edu.miu.spring.data.controller;

import edu.miu.spring.data.dto.CategoryDto;
import edu.miu.spring.data.dto.ProductDto;
import edu.miu.spring.data.entity.Category;
import edu.miu.spring.data.entity.Product;
import edu.miu.spring.data.repo.ProductRepo;
import edu.miu.spring.data.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ModelMapper modelMapper;
    ProductService productService;

    ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping
    public List<ProductDto> findAll(){
        return productService.findAll().stream().map(x->modelMapper.map(x, ProductDto.class))
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable int id){

        Product product=productService.getById(id);
        ProductDto productDto=modelMapper.map(product, ProductDto.class);
        return ResponseEntity.ok().body(productDto);

    }
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto){
        Product product=modelMapper.map(productDto, Product.class);
        productService.save(product);

        return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.delete(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct( int id, ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        productService.update(id,product);
        return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
    }
    @GetMapping("/price")
    public ResponseEntity<List<ProductDto>> findAllByPriceGreaterThan(@RequestParam int minPrice){
        List<ProductDto> productDto = productService.findAllByPriceGreaterThan(minPrice)
                .stream().map(x->modelMapper.map(x, ProductDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(productDto);
    }
    @GetMapping("/category")
    public ResponseEntity<List<ProductDto>> findAllCategoryAndPriceLessThan(@RequestBody Category carDto, @PathVariable int maxPrice){
        Category category=modelMapper.map(carDto, Category.class);
        List<Product> product = productService.findAllCategoryAndPriceLessThan(category, maxPrice);
        List<ProductDto> productDto=product.stream().map(x-> modelMapper.map(x,ProductDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(productDto);
    }
    @GetMapping("/name")
    public ResponseEntity<List<ProductDto>> findAllByNameContaining(@PathVariable String keyword){
        List<ProductDto> productDto= productService.findAllByNameContaining(keyword).stream()
                .map(x->modelMapper.map(x, ProductDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(productDto);
    }
}
