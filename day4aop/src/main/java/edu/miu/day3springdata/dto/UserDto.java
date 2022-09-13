package edu.miu.day3springdata.dto;

import edu.miu.day3springdata.entity.Address;
import edu.miu.day3springdata.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    private AddressDto address;
    private List<ReviewDto> review;
}
