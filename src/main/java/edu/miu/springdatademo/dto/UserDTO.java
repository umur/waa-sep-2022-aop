package edu.miu.springdatademo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.springdatademo.entity.Address;
import edu.miu.springdatademo.entity.Review;
import lombok.Data;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
@Data
public class UserDTO {
    private Integer id;
    private  String email;
    private String password;
    private String firstName;
    private String lastName;

@JsonBackReference
    private List<ReviewDTO> reviews;


    private AddressDTO address;
}
