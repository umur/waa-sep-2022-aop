package WAA.spring.data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.transaction.Transactional;

@Data
@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private double price;
    private int rating;

    @JsonManagedReference
    @JoinColumn
    @ManyToOne(cascade= CascadeType.MERGE)
    private Category category;


}
