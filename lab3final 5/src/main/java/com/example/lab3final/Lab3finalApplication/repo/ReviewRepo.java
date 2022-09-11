package com.example.lab3final.Lab3finalApplication.repo;

import com.example.lab3final.Lab3finalApplication.entity.bidirectional.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review,Integer> {
    List<Review> findAllByProductId(int id);
}
