package edu.miu.springdatademo.service.impl;

import edu.miu.springdatademo.dto.UserDTO;
import edu.miu.springdatademo.entity.User;
import edu.miu.springdatademo.repo.UserRepo;
import edu.miu.springdatademo.service.UserService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private ModelMapper modelMapper;

    @Override
    public List<UserDTO> getAllUser() {
        return userRepo.findAll().stream().map(userA->modelMapper.map(userA,UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Integer id) {
        return modelMapper.map(userRepo.findById(id).orElseThrow(()->new RuntimeException("Incorrect ID")),UserDTO.class);
    }

    @Override
    public UserDTO SaveUser(UserDTO userDTO) {
        return modelMapper.map(userRepo.save(modelMapper.map(userDTO, User.class)),UserDTO.class);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer id) {
        User userA= modelMapper.map(userDTO,User.class);
        userA=userRepo.save(userA);
        return modelMapper.map(userA,UserDTO.class);
    }

    @Override
    public UserDTO deleteUser(Integer id) {
        User userA=userRepo.findById(id).orElseThrow(()->new RuntimeException("incorrect Id"));
        userRepo.delete(userA);
        return modelMapper.map(userA,UserDTO.class);
    }
}
