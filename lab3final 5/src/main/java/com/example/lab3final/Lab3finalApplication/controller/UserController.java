package com.example.lab3final.Lab3finalApplication.controller;

import com.example.lab3final.Lab3finalApplication.entity.bidirectional.User;
import com.example.lab3final.Lab3finalApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("labs/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public void save(@RequestBody User u){
        userService.save(u);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public  void update(@PathVariable int id, @RequestBody User u){
        userService.update(id,u);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id){
        return userService.getById(id);
    }

}
