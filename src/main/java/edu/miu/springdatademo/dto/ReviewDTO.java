package edu.miu.springdatademo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.springdatademo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Integer id;
    private String comment;

    @JsonBackReference
    private User user;
}
