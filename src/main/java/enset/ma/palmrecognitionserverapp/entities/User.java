package enset.ma.palmrecognitionserverapp.entities;

import enset.ma.palmrecognitionserverapp.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 10)
    private UserType type;      // INTERNAL, VISITOR, BLACKLIST

    private String password;

    private Integer acGroupNumber; // 0 = none

}