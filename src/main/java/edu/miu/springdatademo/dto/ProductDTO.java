package edu.miu.springdatademo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.springdatademo.entity.Category;
import lombok.Data;

import javax.persistence.OneToOne;

@Data
public class ProductDTO {
    private Integer id;

    private String name;
    private Double price;
    private Integer rating;
    @JsonBackReference
    private CategoryDTO categoryDTO;
}
