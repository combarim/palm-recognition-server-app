package enset.ma.palmrecognitionserverapp.web;

import enset.ma.palmrecognitionserverapp.dto.request.TimePeriodDto;
import enset.ma.palmrecognitionserverapp.dto.request.UserDto;
import enset.ma.palmrecognitionserverapp.entities.TimePeriod;
import enset.ma.palmrecognitionserverapp.entities.User;
import enset.ma.palmrecognitionserverapp.services.TimePeriodService;
import enset.ma.palmrecognitionserverapp.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable  Long id ) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        log.info("Creating new  user: {}", userDto.toString());
        return userService.saveUser(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        if (userService.getUserById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        userDto.setId(id);
        return ResponseEntity.ok(userService.saveUser(userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.getUserById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(id);
        log.info("Deleted user with id: {}", id);
        return ResponseEntity.noContent().build();
    }
}
