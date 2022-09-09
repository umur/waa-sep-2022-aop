package henry.waasep2022aop.service;

import henry.waasep2022aop.dto.UserDto;

import java.util.List;

public interface UserService {
    void save(UserDto userDto);
    List<UserDto> findAll();
    void update(int userId, UserDto userDto);
    UserDto delete(int userId);
}
