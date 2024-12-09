package com.client.client_service.client_service.service;


import com.client.client_service.client_service.client.ProviderClient;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ProviderClient providerClient;

    public ClientService(ProviderClient providerClient) {
        this.providerClient = providerClient;
    }


    public String callSuccessEndpoint() {
        return providerClient.getSuccess().getBody();
    }

    public String callTransientFailureEndpoint() {
        return providerClient.getTransientFailure().getBody();
    }

    public String callTimeoutEndpoint() {
        return providerClient.getTimeout().getBody();
    }

    public String callNonTransientFailureEndpoint() {
        return providerClient.getNonTransientFailure().getBody();
    }
}
