package com.jlucka.mirror.service;

import com.jlucka.mirror.model.QuoteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteService {

    private static final Logger log = LoggerFactory.getLogger(QuoteService.class);

    @Value("${quote.url}")
    private String quoteUrl;

    private QuoteResponse internalGetQuote() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<String> entity = new HttpEntity<>("parameters");
            ResponseEntity<QuoteResponse> response = restTemplate.exchange(quoteUrl, HttpMethod.GET, entity, QuoteResponse.class);
            return response.getBody();
        } catch (RestClientException e) {
            log.warn("Problem getting quote data from talaikis - quote of day");
            return new QuoteResponse("Whenever you find yourself on the side of the majority, it is time to pause and reflect.", "Mark Twain");
        }
    }

    public QuoteResponse getQuote() {
        QuoteResponse quote;
        do {
            quote = internalGetQuote();
        } while (quote.getQuote().length() > 120);
        return quote;
    }

}