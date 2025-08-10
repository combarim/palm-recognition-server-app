package enset.ma.palmrecognitionserverapp.services;


import enset.ma.palmrecognitionserverapp.dto.request.UserDto;
import enset.ma.palmrecognitionserverapp.entities.User;
import enset.ma.palmrecognitionserverapp.enums.UserType;
import enset.ma.palmrecognitionserverapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class UserService {

    private final UserRepository userRepository;
    private final MiddlewareService middlewareService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(UserDto userDto) {
        User user = userFromDto(userDto);
        user.setId(null);
        User savedUser = userRepository.save(user);
        middlewareService.createOrUpdateUser(savedUser);
        return savedUser;
    }

    private User userFromDto(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        UserType userType = UserType.fromValue(userDto.getType());
        user.setType(userType);
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setAcGroupNumber(userDto.getAcGroupNumber() != null ? userDto.getAcGroupNumber() : 0);
        return user;
    }


    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }
}
