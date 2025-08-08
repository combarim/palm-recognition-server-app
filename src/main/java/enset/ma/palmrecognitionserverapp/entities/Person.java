package enset.ma.palmrecognitionserverapp.entities;


import enset.ma.palmrecognitionserverapp.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @Column(nullable = false)
    private String name;


    private UserType type;

    private String password;

    private String card;
    private String faceNumber;
    private String fingerNumber;
    private String palmVeinNumber;

    @ManyToOne
    private AccessControlGroup controlGroup;

}
