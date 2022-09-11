package WAA.spring.data.controller;

import WAA.spring.data.dto.CategoryDto;
import WAA.spring.data.dto.ProductDto;
import WAA.spring.data.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getByid(@PathVariable int id){
        ProductDto productDto=productService.getById(id);
        return ResponseEntity.ok().body(productDto);
    }
    @PostMapping
    public  ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDtoReq){
        ProductDto productDtoRes=productService.save(productDtoReq);
        return new ResponseEntity<>(productDtoRes, HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
       productService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable int id, @RequestBody ProductDto productDtoreq){
        ProductDto productDtores=productService.update(id,productDtoreq);
        return new ResponseEntity<>(productDtores,HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<List<ProductDto>> findAllByPriceGreaterThan(@RequestParam double minPrice){
        return ResponseEntity.ok().body(productService.findAllByPriceGreaterThan(minPrice));
    }

    @GetMapping("/catagory")
    public ResponseEntity<List<ProductDto>> findAllByCategoryAndPriceLessThan(@RequestBody CategoryDto catDto, @RequestParam double maxPrice){
        return ResponseEntity.ok().body(productService.findAllByCategoryAndPriceLessThan(catDto,maxPrice));
    }
    @GetMapping("/filter/{name}")
    public ResponseEntity<List<ProductDto>> findAllByNameContaining(@PathVariable String name){
        return ResponseEntity.ok().body(productService.findAllByNameContaining(name));
    }






}
