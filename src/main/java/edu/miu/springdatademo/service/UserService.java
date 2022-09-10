package edu.miu.springdatademo.service;

import edu.miu.springdatademo.dto.UserDTO;

import java.util.List;

public interface UserService {
    //Read
    public List<UserDTO> getAllUser();
    public UserDTO getUserById(Integer id);
    //Create
    public UserDTO SaveUser(UserDTO userDTO);

    //Update
    public UserDTO updateUser(UserDTO userDTO, Integer id);

    //delete
    public UserDTO deleteUser(Integer id);






}
