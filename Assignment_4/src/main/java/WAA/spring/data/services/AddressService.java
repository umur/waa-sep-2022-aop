package WAA.spring.data.services;

import WAA.spring.data.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    void save(Address address);
    Address getById(int id);
    void update(int id, Address addressreq);
    void delete(int id);
    List<Address> findAll();

}
