package henry.waasep2022aop.service.impl;

import henry.waasep2022aop.dto.UserDto;
import henry.waasep2022aop.entity.User;
import henry.waasep2022aop.mapper.ListMapper;
import henry.waasep2022aop.repo.UserRepo;
import henry.waasep2022aop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;

    @Override
    public void save(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public List<UserDto> findAll() {
        return listMapper.map((List<User>)userRepo.findAll(), UserDto.class);
    }

    @Override
    public void update(int userId, UserDto userDto) {
        if (userRepo.findById(userId).isPresent()) {
            User newUser = modelMapper.map(userDto, User.class);
            newUser.setId(userId);
            userRepo.save(newUser);
        }
    }

    @Override
    public UserDto delete(int userId) {
        User user = userRepo.findById(userId).orElse(null);
        userRepo.deleteById(userId);
        return user != null ? modelMapper.map(user, UserDto.class) : null;
    }
}
