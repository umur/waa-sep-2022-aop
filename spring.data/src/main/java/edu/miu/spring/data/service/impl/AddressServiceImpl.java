package edu.miu.spring.data.service.impl;

import edu.miu.spring.data.entity.Address;
import edu.miu.spring.data.repo.AddressRepo;
import edu.miu.spring.data.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;


    @Override
    public void save(Address address) {
        addressRepo.save(address);
    }

    @Override
    public Address getById(int id) {
        return addressRepo.findById(id).orElse(null);
    }

    @Override
    public void update(int id, Address addressReq) {
        Address address =addressRepo.findById(id).orElse(null);

        address.setCity(addressReq.getCity());
        address.setStreet(addressReq.getStreet());
        address.setZip(addressReq.getZip());

    }

    @Override
    public void delete(int id) {
        Address address =addressRepo.findById(id).orElse(null);
        addressRepo.delete(address);
    }

    @Override
    public List<Address> findAll() {
        return (List<Address>) addressRepo.findAll();
    }
}
