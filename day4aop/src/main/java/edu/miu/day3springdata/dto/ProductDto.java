package edu.miu.day3springdata.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.miu.day3springdata.entity.Category;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {
    private Integer id;
    private String name;
    private double price;
    private Integer rating;

    //@JsonManagedReference
    private CategoryDto category;

    private Set<ReviewDto> reviews;
}
