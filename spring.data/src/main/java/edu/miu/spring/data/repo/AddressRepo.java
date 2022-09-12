package edu.miu.spring.data.repo;

import edu.miu.spring.data.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address, Integer> {
}
