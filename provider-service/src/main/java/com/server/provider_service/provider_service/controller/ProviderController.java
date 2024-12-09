package com.server.provider_service.provider_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProviderController {
    @GetMapping("/success")
    public ResponseEntity<String> getSuccess() {
        return ResponseEntity.ok("Success!");
    }

    @GetMapping("/transient-failure")
    public ResponseEntity<String> getTransientFailure() {
        if (Math.random() < 0.5) {
            throw new RuntimeException("Transient error, please retry.");
        }
        return ResponseEntity.ok("Recovered from transient failure!");
    }

    @GetMapping("/timeout")
    public ResponseEntity<String> getTimeout() throws InterruptedException {
        Thread.sleep(5000); // Simulate timeout
        return ResponseEntity.ok("Timeout recovery successful!");
    }

    @GetMapping("/non-transient-failure")
    public ResponseEntity<String> getNonTransientFailure() {
        throw new IllegalStateException("Non-transient error occurred.");
    }
}
