package com.client.client_service.client_service.config;

import feign.RequestInterceptor;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            template.header("Authorization", "Bearer your-token");
            template.header("Content-Type", "application/json");
        };
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100, 1000, 3); // Retry 3 times with exponential backoff
    }
}
