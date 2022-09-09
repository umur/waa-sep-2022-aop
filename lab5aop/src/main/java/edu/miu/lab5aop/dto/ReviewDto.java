package edu.miu.lab5aop.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
public class ReviewDto {

    private Integer id;

    private String comment;

    @JsonBackReference
    private UserDto user;
}
