package enset.ma.palmrecognitionserverapp.services;


import enset.ma.palmrecognitionserverapp.dto.request.TimePeriodDto;
import enset.ma.palmrecognitionserverapp.entities.TimePeriod;
import enset.ma.palmrecognitionserverapp.repositories.TimePeriodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TimePeriodService {

    private final TimePeriodRepository timePeriodRepository;
    private final MiddlewareService middlewareService;


    public List<TimePeriod> getAllTimePeriods() {
        return timePeriodRepository.findAll();
    }

    public Optional<TimePeriod> getTimePeriodById(Integer id) {
        return timePeriodRepository.findById(id);
    }

    public TimePeriod saveTimePeriod(TimePeriodDto timePeriodDto) {
        TimePeriod timePeriod = new TimePeriod();
        updateTimePeriodFromDto(timePeriod, timePeriodDto);
        timePeriod.setTimePeriodId(null);
        updateTimePeriodFromDto(timePeriod, timePeriodDto);
        TimePeriod savedTimePeriod = timePeriodRepository.save(timePeriod);
        middlewareService.createOrUpdateTimePeriod(savedTimePeriod);
        return savedTimePeriod;
    }

    private void updateTimePeriodFromDto(TimePeriod entity, TimePeriodDto dto) {
        entity.setTimePeriodName(dto.getAcTzName());
        entity.setSunStart(LocalTime.parse(dto.getSunStart()));
        entity.setSunEnd(LocalTime.parse(dto.getSunEnd()));
        entity.setMonStart(LocalTime.parse(dto.getMonStart()));
        entity.setMonEnd(LocalTime.parse(dto.getMonEnd()));
        entity.setTueStart(LocalTime.parse(dto.getTueStart()));
        entity.setTueEnd(LocalTime.parse(dto.getTueEnd()));
        entity.setWedStart(LocalTime.parse(dto.getWedStart()));
        entity.setWedEnd(LocalTime.parse(dto.getWedEnd()));
        entity.setThursStart(LocalTime.parse(dto.getThursStart()));
        entity.setThursEnd(LocalTime.parse(dto.getThursEnd()));
        entity.setFriStart(LocalTime.parse(dto.getFriStart()));
        entity.setFriEnd(LocalTime.parse(dto.getFriEnd()));
        entity.setSatStart(LocalTime.parse(dto.getSatStart()));
        entity.setSatEnd(LocalTime.parse(dto.getSatEnd()));
    }

    public void deleteTimePeriod(Integer id) {
        timePeriodRepository.deleteById(id);
    }


}