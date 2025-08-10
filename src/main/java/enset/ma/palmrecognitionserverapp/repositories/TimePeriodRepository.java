package enset.ma.palmrecognitionserverapp.repositories;


import enset.ma.palmrecognitionserverapp.entities.TimePeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimePeriodRepository extends JpaRepository<TimePeriod, Integer> {
}