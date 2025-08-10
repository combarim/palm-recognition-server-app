package enset.ma.palmrecognitionserverapp;

import enset.ma.palmrecognitionserverapp.entities.TimePeriod;
import enset.ma.palmrecognitionserverapp.enums.UserType;
import enset.ma.palmrecognitionserverapp.repositories.TimePeriodRepository;
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
    CommandLineRunner commandLineRunner(TimePeriodRepository repository)
    {
        return args -> {
            Stream.of("conge","cours2","cours3").forEach(name -> {
                TimePeriod timePeriod = new TimePeriod();
                timePeriod.setTimePeriodName(name);
                repository.save(timePeriod);
            });
        };
    }

}
