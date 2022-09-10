package edu.miu.springdatademo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.springdatademo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Integer id;
    private String street;
    private Integer zip;
    private String city;
}
