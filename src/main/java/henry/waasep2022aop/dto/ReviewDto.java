package henry.waasep2022aop.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link henry.waasep2022aop.entity.Review} entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewDto implements Serializable {
    private int id;
    private String comment;
    @JsonBackReference
    private UserDto user;
}