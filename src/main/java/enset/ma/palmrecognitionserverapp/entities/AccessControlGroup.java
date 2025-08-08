package enset.ma.palmrecognitionserverapp.entities;

import enset.ma.palmrecognitionserverapp.enums.VerifyStyle;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AccessControlGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long controlGroupId;

    private String name;
    private VerifyStyle verifyStyle;


    @ManyToOne
    @JoinColumn(name = "time_period_1_id")
    private TimePeriod timePeriod1;

    @ManyToOne
    @JoinColumn(name = "time_period_2_id")
    private TimePeriod timePeriod2;

    @ManyToOne
    @JoinColumn(name = "time_period_3_id")
    private TimePeriod timePeriod3;
}
