package henry.waasep2022aop.controller;

import henry.waasep2022aop.aspect.annotation.ExecutionTime;
import henry.waasep2022aop.dto.UserDto;
import henry.waasep2022aop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @ExecutionTime
    @PostMapping
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @ExecutionTime
    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @ExecutionTime
    @PutMapping("/{userId}")
    public void update(@PathVariable int userId, @RequestBody UserDto userDto) {
        userService.update(userId, userDto);
    }

    @ExecutionTime
    @DeleteMapping("/{userId}")
    public UserDto delete(@PathVariable int userId) {
        return userService.delete(userId);
    }
}
