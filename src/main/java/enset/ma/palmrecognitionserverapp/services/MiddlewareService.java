package enset.ma.palmrecognitionserverapp.services;

import enset.ma.palmrecognitionserverapp.dto.request.TimePeriodDto;
import enset.ma.palmrecognitionserverapp.entities.TimePeriod;
import enset.ma.palmrecognitionserverapp.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@RequiredArgsConstructor
@Slf4j
public class MiddlewareService {

    private final WebClient webClient;

    @Value("${middleware.secret}")
    private String secret;

    @Value("${middleware.deviceKey}")
    private String deviceKey;


    public void createOrUpdateTimePeriod(TimePeriod timePeriod) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("secret", secret);
        formData.add("deviceKey", deviceKey);
        formData.add("acTzNumber", timePeriod.getTimePeriodId().toString());
        formData.add("acTzName", timePeriod.getTimePeriodName());
        formData.add("sunStart", timePeriod.getSunStart().toString());
        formData.add("sunEnd", timePeriod.getSunEnd().toString());
        formData.add("monStart", timePeriod.getMonStart().toString());
        formData.add("monEnd", timePeriod.getMonEnd().toString());
        formData.add("tueStart", timePeriod.getTueStart().toString());
        formData.add("tueEnd", timePeriod.getTueEnd().toString());
        formData.add("wedStart", timePeriod.getWedStart().toString());
        formData.add("wedEnd", timePeriod.getWedEnd().toString());
        formData.add("thursStart", timePeriod.getThursStart().toString());
        formData.add("thursEnd", timePeriod.getThursEnd().toString());
        formData.add("friStart", timePeriod.getFriStart().toString());
        formData.add("friEnd", timePeriod.getFriEnd().toString());
        formData.add("satStart", timePeriod.getSatStart().toString());
        formData.add("satEnd", timePeriod.getSatEnd().toString());

        String response = webClient.post()
                .uri("/api/ac_timezone/merge")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue(formData)
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(e -> {
                    throw new RuntimeException("Middleware call failed", e);
                })
                .block();
        log.info(response);
    }

    public void createOrUpdateUser(User savedUser) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("secret", secret);
        formData.add("deviceKey", deviceKey);
        formData.add("sn", savedUser.getId().toString());
        formData.add("name", savedUser.getName());
        formData.add("type", savedUser.getType().toValue().toString());
        formData.add("verifyPwd", savedUser.getPassword());
        formData.add("acGroupNumber", savedUser.getAcGroupNumber().toString());

        String response = webClient.post()
                .uri("/api/person/create")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue(formData)
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(e -> {
                    throw new RuntimeException("Middleware call failed", e);
                })
                .block();
        log.info(response);
    }
}
