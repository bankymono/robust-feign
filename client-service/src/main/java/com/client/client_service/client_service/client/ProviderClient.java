package com.client.client_service.client_service.client;


import com.client.client_service.client_service.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "providerClient",
        url = "http://localhost:8081", // URL of provider-service
        configuration = FeignConfig.class
)
public interface ProviderClient {

    @GetMapping("/api/success")
    ResponseEntity<String> getSuccess();

    @GetMapping("/api/transient-failure")
    ResponseEntity<String> getTransientFailure();

    @GetMapping("/api/timeout")
    ResponseEntity<String> getTimeout();

    @GetMapping("/api/non-transient-failure")
    ResponseEntity<String> getNonTransientFailure();
}
