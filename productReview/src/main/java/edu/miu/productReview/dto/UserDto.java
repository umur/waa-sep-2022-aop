package edu.miu.productReview.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.miu.productReview.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    //@JsonManagedReference
    private AddressDto address;
}
