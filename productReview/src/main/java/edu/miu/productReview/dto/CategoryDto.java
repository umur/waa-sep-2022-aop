package edu.miu.productReview.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.miu.productReview.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
    private int id;
    private String name;
}
