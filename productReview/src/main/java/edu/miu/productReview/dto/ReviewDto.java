package edu.miu.productReview.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.productReview.domain.Product;
import edu.miu.productReview.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewDto {
    private int id;
    private String comment;
    //@JsonBackReference
    private UserDto user;
}
