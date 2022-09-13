package edu.miu.day3springdata.dto;

import edu.miu.day3springdata.entity.User;
import lombok.*;

import javax.persistence.ManyToOne;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ReviewDto {
    private Integer id;
    private String comment;
    private User user;
}
