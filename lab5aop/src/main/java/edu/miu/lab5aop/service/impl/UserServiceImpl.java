package edu.miu.lab5aop.service.impl;

import edu.miu.lab5aop.dto.UserDto;
import edu.miu.lab5aop.entity.User;
import edu.miu.lab5aop.mapper.UserMapper;
import edu.miu.lab5aop.repo.UserRepository;
import edu.miu.lab5aop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public List<UserDto> getUsers() {
        return userMapper.toDtos((List<User>) userRepository.findAll());
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void add(UserDto userDto) {
        userRepository.save(userMapper.toEntity(userDto));
    }
}
