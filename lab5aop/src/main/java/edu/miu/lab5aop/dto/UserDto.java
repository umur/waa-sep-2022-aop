package edu.miu.lab5aop.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Integer id;

    private String email;

    private String firstName;

    private String lastName;

    @JsonManagedReference
    private List<ReviewDto> reviews;

    private AddressDto address;

}
