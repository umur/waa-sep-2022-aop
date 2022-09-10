package edu.miu.springdatademo.controller;

import edu.miu.springdatademo.dto.AddressDTO;
import edu.miu.springdatademo.repo.AddressRepo;
import edu.miu.springdatademo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")

public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public AddressDTO save(@RequestBody AddressDTO addressDTO){
        return addressService.SaveAddress(addressDTO);
    }

    @GetMapping
    public List<AddressDTO> findAll(){
        return addressService.getAllAddress();
    }

    @GetMapping("/{id}")
    public  AddressDTO find(@PathVariable Integer id){
        return addressService.getAddressById(id);
    }

    @PutMapping("/{id}")
    public AddressDTO update(@PathVariable Integer id, @RequestBody AddressDTO addressDTO){
        return addressService.updateAddress(addressDTO, id);
    }


}
