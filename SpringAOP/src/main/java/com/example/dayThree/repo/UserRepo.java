package com.example.dayThree.repo;

import com.example.dayThree.entity.Product;
import com.example.dayThree.entity.Review;
import com.example.dayThree.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select r from Review r join User u on u.id = r.user.id where u.id = :id")
    List<Review> findReviewsByUserId(long id);
}
