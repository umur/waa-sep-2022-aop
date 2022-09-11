package WAA.spring.data.dto;

import WAA.spring.data.entity.Category;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
// @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY )
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private int rating;

    private CategoryDto category;

}
