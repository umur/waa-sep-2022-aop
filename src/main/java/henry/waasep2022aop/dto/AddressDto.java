package henry.waasep2022aop.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link henry.waasep2022aop.entity.Address} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDto implements Serializable {
    private int id;
    private String street;
    private String zip;
    private String city;
    @JsonBackReference
    private UserDto user;
}