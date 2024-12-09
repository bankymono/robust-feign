package com.client.client_service.client_service.controller;


import com.client.client_service.client_service.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/success")
    public ResponseEntity<String> getSuccess() {
        return ResponseEntity.ok(clientService.callSuccessEndpoint());
    }

    @GetMapping("/retry")
    public ResponseEntity<String> getTransientFailure() {
        return ResponseEntity.ok(clientService.callTransientFailureEndpoint());
    }

    @GetMapping("/timeout")
    public ResponseEntity<String> getTimeout() {
        return ResponseEntity.ok(clientService.callTimeoutEndpoint());
    }

    @GetMapping("/non-transient")
    public ResponseEntity<String> getNonTransientFailure() {
        return ResponseEntity.ok(clientService.callNonTransientFailureEndpoint());
    }
}
