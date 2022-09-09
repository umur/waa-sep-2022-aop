package edu.miu.lab5aop.mapper;

import edu.miu.lab5aop.dto.UserDto;
import edu.miu.lab5aop.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> toDtos(List<User> users) {
        return users.stream()
                .map(this::toDto)
                .toList();
    }

    public User toEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public List<User> toEntities(List<UserDto> userDtos) {
        return userDtos.stream()
                .map(this::toEntity)
                .toList();
    }
}
