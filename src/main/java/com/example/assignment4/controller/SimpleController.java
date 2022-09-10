package com.example.assignment4.controller;

import com.example.assignment4.service.SimpleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SimpleController {

    private final SimpleService simpleService;

    @PostMapping("/simple")
    private String simplePost(){
        return simpleService.simpleWithoutLog();
    }

    @PostMapping("/log")
    private String logPost(){
        return simpleService.simpleWithLog();
    }
}
