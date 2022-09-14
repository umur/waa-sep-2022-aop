package edu.miu.spring.data.repo;

import edu.miu.spring.data.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
}
