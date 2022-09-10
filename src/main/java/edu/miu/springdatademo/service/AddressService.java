package edu.miu.springdatademo.service;

import edu.miu.springdatademo.dto.AddressDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    //Read
    public List<AddressDTO> getAllAddress();
    public AddressDTO getAddressById(Integer id);
    //Create
    public AddressDTO SaveAddress(AddressDTO addressDTO);

    //Update
    public AddressDTO updateAddress(AddressDTO addressDTO, Integer id);

    //delete
    public AddressDTO deleteAddress(Integer id);
}
