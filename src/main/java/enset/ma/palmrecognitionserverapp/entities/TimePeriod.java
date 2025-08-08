package enset.ma.palmrecognitionserverapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
public class TimePeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timePeriodId;
    private String timePeriodName;
    private LocalTime sunday;
    private LocalTime monday;
    private LocalTime tuesday;
    private LocalTime wednesday;
    private LocalTime thursday;
    private LocalTime friday;
    private LocalTime saturday;
}
