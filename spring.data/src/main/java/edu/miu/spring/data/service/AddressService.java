package edu.miu.spring.data.service;

import edu.miu.spring.data.entity.Address;

import java.util.List;

public interface AddressService {
    void save(Address address);
    Address getById(int id);
    void update(int id, Address addressReq);
    void delete(int id);
    List<Address> findAll();
}
