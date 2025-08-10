package enset.ma.palmrecognitionserverapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimePeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer timePeriodId;

    private String timePeriodName;

    private LocalTime sunStart;
    private LocalTime sunEnd;
    private LocalTime monStart;
    private LocalTime monEnd;
    private LocalTime tueStart;
    private LocalTime tueEnd;
    private LocalTime wedStart;
    private LocalTime wedEnd;
    private LocalTime thursStart;
    private LocalTime thursEnd;
    private LocalTime friStart;
    private LocalTime friEnd;
    private LocalTime satStart;
    private LocalTime satEnd;
}
