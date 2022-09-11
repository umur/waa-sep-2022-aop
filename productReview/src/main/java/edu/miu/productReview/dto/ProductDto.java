package edu.miu.productReview.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.miu.productReview.domain.Category;
import edu.miu.productReview.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private int id;
    private String name;
    private Float price;
    private Float rating;

    //@JsonManagedReference
    private CategoryDto category;

    //@JsonBackReference
    private List<ReviewDto> reviews;
}
