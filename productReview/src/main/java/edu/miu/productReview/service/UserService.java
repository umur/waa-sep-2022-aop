package edu.miu.productReview.service;

import edu.miu.productReview.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto user);
    List<UserDto> findAll();
    UserDto findById(int id);
    UserDto update(int id, UserDto user);
    void delete(int id);
}
