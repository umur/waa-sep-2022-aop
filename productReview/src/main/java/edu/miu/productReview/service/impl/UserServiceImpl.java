package edu.miu.productReview.service.impl;

import edu.miu.productReview.domain.User;
import edu.miu.productReview.dto.UserDto;
import edu.miu.productReview.repo.UserRepo;
import edu.miu.productReview.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public UserDto save(UserDto user) {
        User result = userRepo.save(mapper.map(user, User.class));
        return mapper.map(result, UserDto.class);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        return users.stream().map(u -> mapper.map(u, UserDto.class)).toList();
    }

    @Override
    public UserDto findById(int id) {
        return userRepo.findById(id).map(user -> mapper.map(user, UserDto.class)).orElse(new UserDto());
    }

    @Override
    public UserDto update(int id, UserDto user) {
        User result = userRepo.findById(id).get();
        if(result != null) {
            user.setId(result.getId());
            userRepo.save(mapper.map(user, User.class));
            return user;
        } else throw new IllegalArgumentException();
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }
}
