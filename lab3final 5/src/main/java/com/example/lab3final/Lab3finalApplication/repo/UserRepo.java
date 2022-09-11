package com.example.lab3final.Lab3finalApplication.repo;

import com.example.lab3final.Lab3finalApplication.entity.bidirectional.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {

}
