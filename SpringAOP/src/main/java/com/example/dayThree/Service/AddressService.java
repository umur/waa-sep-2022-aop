package com.example.dayThree.Service;

import com.example.dayThree.entity.Address;
import com.example.dayThree.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepo addressRepo;
    public List<Address> getAllAddress() {
      return addressRepo.findAll();
    }

    public Optional<Address> getAddressById(long id) {
        return addressRepo.findById(id);
    }
}
