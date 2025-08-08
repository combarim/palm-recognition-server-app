package enset.ma.palmrecognitionserverapp.web;

import enset.ma.palmrecognitionserverapp.entities.Person;
import enset.ma.palmrecognitionserverapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@AllArgsConstructor

public class UserController {

    private UserRepository userRepository;

    @GetMapping("/users")
    public List<Person> users(){
        return userRepository.findAll();
    }

    @PostMapping("/user/{userId}")
    public Person addUser(@PathVariable int userId, @RequestBody Person person){
        return userRepository.save(person);
    }
}
