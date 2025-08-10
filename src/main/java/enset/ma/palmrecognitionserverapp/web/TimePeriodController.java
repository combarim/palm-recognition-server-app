package enset.ma.palmrecognitionserverapp.web;


import enset.ma.palmrecognitionserverapp.dto.request.TimePeriodDto;
import enset.ma.palmrecognitionserverapp.entities.TimePeriod;
import enset.ma.palmrecognitionserverapp.services.TimePeriodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/time-periods")
@Slf4j
public class TimePeriodController {

    private final TimePeriodService timePeriodService;

    public TimePeriodController(TimePeriodService timePeriodService) {
        this.timePeriodService = timePeriodService;
    }

    @GetMapping
    public List<TimePeriod> getAllTimePeriods() {
        return timePeriodService.getAllTimePeriods();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimePeriod> getTimePeriodById(@PathVariable Integer id) {
        Optional<TimePeriod> timePeriod = timePeriodService.getTimePeriodById(id);
        return timePeriod.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TimePeriod createTimePeriod(@RequestBody TimePeriodDto timePeriodDto) {
        log.info("Creating time period: {}", timePeriodDto);
        return timePeriodService.saveTimePeriod(timePeriodDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimePeriod> updateTimePeriod(@PathVariable Integer id, @RequestBody TimePeriodDto timePeriod) {
        if (timePeriodService.getTimePeriodById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        timePeriod.setAcTzNumber(id);
        return ResponseEntity.ok(timePeriodService.saveTimePeriod(timePeriod));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimePeriod(@PathVariable Integer id) {
        if (timePeriodService.getTimePeriodById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        timePeriodService.deleteTimePeriod(id);
        return ResponseEntity.noContent().build();
    }
}