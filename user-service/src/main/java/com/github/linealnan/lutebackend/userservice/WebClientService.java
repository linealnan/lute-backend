package com.github.linealnan.lutebackend.userservice;

import com.github.linealnan.lutebackend.userservice.model.User;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientService {
    private static final String API_MIME_TYPE = "application/json";
    private static final String API_BASE_URL = "http://localhost:8081";
    private static final String USER_AGENT = "User Service";
    private static final Logger logger = LoggerFactory.getLogger(WebClientService.class);

    private WebClient webClient;

    public WebClientService() {
        this.webClient = WebClient.builder()
                .baseUrl(API_BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, API_MIME_TYPE)
                .defaultHeader(HttpHeaders.USER_AGENT, USER_AGENT)
//                .filter(WebClientService.errorHandlingFilter())
                .build();
    }

    public Flux<User> getDataByWebClient() {
        return webClient
                .get()
                .uri("/stream/buckets/delay")
                .exchange()
                .flatMapMany(clientResponse -> clientResponse.bodyToFlux(User.class));
    }
}