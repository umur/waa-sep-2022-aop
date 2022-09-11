package WAA.spring.data.services;

import WAA.spring.data.dto.CategoryDto;
import WAA.spring.data.dto.ProductDto;
import WAA.spring.data.entity.Address;
import WAA.spring.data.entity.Category;
import WAA.spring.data.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDto save(ProductDto productDto);
    ProductDto getById(int id);
    ProductDto update(int id, ProductDto productDtoreq);
    void delete(int id);
    List<ProductDto> findAll();
    public List<ProductDto> findAllByPriceGreaterThan(double minPrice);
    public List<ProductDto> findAllByCategoryAndPriceLessThan(CategoryDto cat, double maxPrice);
    public List<ProductDto> findAllByNameContaining(String keyword);

}
