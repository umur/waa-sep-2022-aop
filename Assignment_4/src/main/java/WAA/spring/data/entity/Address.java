package WAA.spring.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Address {
    @Id
    private int id;
    private String street;
    private String zip;
    private String city;

    @OneToOne
    private User user;

}
