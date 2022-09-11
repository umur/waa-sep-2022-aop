package WAA.spring.data.dto;

import WAA.spring.data.entity.Product;
import lombok.Data;

import java.util.List;
@Data

public class CategoryDto {

    private int id;
    private String name;

   // private List<Product> productList;
}
