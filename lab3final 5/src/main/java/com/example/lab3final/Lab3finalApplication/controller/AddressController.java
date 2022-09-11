package com.example.lab3final.Lab3finalApplication.controller;

import com.example.lab3final.Lab3finalApplication.entity.bidirectional.Address;
import com.example.lab3final.Lab3finalApplication.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lab2/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    @PostMapping
    public void save(@RequestBody Address a){
        addressService.save(a);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        addressService.delete(id);
    }

    @PutMapping("/{id}")
    public  void update(@PathVariable int id, @RequestBody Address p){
        addressService.update(id,p);
    }

    @GetMapping
    public List<Address> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable int id){
        return addressService.getById(id);
    }


}
