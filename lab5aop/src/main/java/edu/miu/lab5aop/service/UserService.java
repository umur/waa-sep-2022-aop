package edu.miu.lab5aop.service;

import edu.miu.lab5aop.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getUsers();

    void delete(int id);

    void add(UserDto userDto);
}
