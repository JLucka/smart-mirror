package com.jlucka.mirror.service;

import com.jlucka.mirror.model.AirlyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class SmogService {

    private static final Logger log = LoggerFactory.getLogger(SmogService.class);

    @Value("${airly.key}")
    private String airlyKey;

    @Value("${airly.url}")
    private String airlyUrl;


    public AirlyResponse getCurrentSmogLevel() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("apikey", airlyKey);
            HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
            ResponseEntity<AirlyResponse> response = restTemplate.exchange(airlyUrl, HttpMethod.GET, entity, AirlyResponse.class);
            return response.getBody();
        } catch (RestClientException e) {
            log.warn("Problem getting smog data from Airly");
            return new AirlyResponse(0, 0, 0, 0);
        }
    }
}
