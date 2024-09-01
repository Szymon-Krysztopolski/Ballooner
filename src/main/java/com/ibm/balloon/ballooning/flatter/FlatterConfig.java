package com.ibm.balloon.ballooning.flatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class FlatterConfig {
    @Bean
    public WebClient flatterWebClient(@Value("${flatter.endpoint}") String endpoint) {
        return WebClient.create(endpoint);
    }
}
