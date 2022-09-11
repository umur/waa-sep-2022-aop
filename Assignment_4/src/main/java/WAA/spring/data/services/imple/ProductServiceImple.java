package WAA.spring.data.services.imple;

import WAA.spring.data.annotation.ExecutionTime;
import WAA.spring.data.dto.CategoryDto;
import WAA.spring.data.dto.ProductDto;
import WAA.spring.data.entity.Category;
import WAA.spring.data.entity.Product;
import WAA.spring.data.repository.ProductRepo;
import WAA.spring.data.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImple implements ProductService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ProductRepo productRepo;

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product=modelMapper.map(productDto, Product.class);
        productRepo.save(product);
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto getById(int id) {
        Product product=productRepo.findById(id).orElse(null);;
        ProductDto productDto=modelMapper.map(product, ProductDto.class);
       return productDto;
    }

    @Override
    //@ExecutionTime
    public ProductDto update(int id, ProductDto productDtoreq) {
        //Product productreq =modelMapper.map(productDtoreq, Product.class);
        Product product=productRepo.findById(id).orElse(null);
        if(product==null)
            throw new NullPointerException("Id is not valid");

        product.setName(productDtoreq.getName());
        product.setPrice(productDtoreq.getPrice());
     //   product.setCategory(productDtoreq.getCategory());
        product.setRating(productDtoreq.getRating());
        productRepo.save(product);

      return modelMapper.map(product, ProductDto.class);

    }

    //@ExecutionTime
    @Override
    public void delete(int id) {
        Product product=productRepo.findById(id).orElse(null);
        if(product==null)
            throw new NullPointerException("Id is not Valid");
        productRepo.delete(product);

    }

    @Override
    @ExecutionTime
    public List<ProductDto> findAll() {
        List<Product> products =(List<Product>) productRepo.findAll();
        List<ProductDto> productDtos=products.stream().map(x->modelMapper.map(x, ProductDto.class))
                .collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public List<ProductDto> findAllByPriceGreaterThan(double minPrice) {
        List<Product> product=productRepo.findAllByPriceGreaterThan(minPrice);
        List<ProductDto> productDtos = product.stream().map(x->modelMapper.map(x, ProductDto.class))
                .collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public List<ProductDto> findAllByCategoryAndPriceLessThan(CategoryDto cat, double maxPrice) {
        Category category=modelMapper.map(cat, Category.class);
        List<Product> product= productRepo.findAllByCategoryAndPriceLessThan(category,maxPrice);;
        List<ProductDto> productDto=product.stream().map(x->modelMapper.map(x, ProductDto.class))
                .collect(Collectors.toList());

        return productDto;
    }

    @Override
    public List<ProductDto> findAllByNameContaining(String keyword) {
        List<Product> products = productRepo.findAllByNameContaining(keyword);
        List<ProductDto> productdto=products.stream()
                .map(x->modelMapper.map(x, ProductDto.class)).collect(Collectors.toList());
        return productdto;
    }
}
