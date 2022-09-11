package WAA.spring.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Review {
    @Id
    private int id;
    private String commont;


    @ManyToOne
    @JoinColumn(name="userssss_id")
    private User user;
}
