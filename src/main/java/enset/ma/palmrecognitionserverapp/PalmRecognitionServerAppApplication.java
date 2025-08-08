package enset.ma.palmrecognitionserverapp;

import enset.ma.palmrecognitionserverapp.entities.Person;
import enset.ma.palmrecognitionserverapp.enums.UserType;
import enset.ma.palmrecognitionserverapp.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class PalmRecognitionServerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalmRecognitionServerAppApplication.class, args);
    }

 @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository)
    {
        return args -> {
            Stream.of("Mohammed","Benoit","Rebani","marius").forEach(name -> {
                Person person =new Person();
                person.setName(name);
                person.setType(UserType.VISITOR);
                userRepository.save(person);
            });
        };
    }

}
