package edu.miu.spring.data.controller;

import edu.miu.spring.data.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AddressController {

    @Autowired
    private AddressService addressService;
}
