package enset.ma.palmrecognitionserverapp.repositories;

import enset.ma.palmrecognitionserverapp.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Person,Long> {
}
