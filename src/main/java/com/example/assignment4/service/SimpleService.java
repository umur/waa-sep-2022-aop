package com.example.assignment4.service;

import com.example.assignment4.annotation.ExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    public String simpleWithoutLog() {
        return "Hello World without log";
    }

    @ExecutionTime
    public String simpleWithLog() {
        return "Hello World with log";
    }
}
