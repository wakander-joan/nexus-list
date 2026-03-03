package com.nexus.nexus_list.user.application.api;

import com.nexus.nexus_list.user.application.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

//@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@Log4j2
public class ClientController implements ClientAPI {
    private final ClientService clientService;

    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        log.info("[start] ClientController - createClient");
        ClientResponse client = clientService.createClient(clientRequest);
        log.info("[finish] ClientController - createClient");
        return client;
    }

    @Override
    public ClientDetailedResponse getClient(UUID idClient) {
        log.info("[start] ClientController - getClient");
        ClientDetailedResponse client =  clientService.getClient(idClient);
        log.info("[finish] ClientController - getClient");
        return client;
    }

    @Override
    public void editClient(UUID idClient, EditClientRequest editClientRequest) {
        log.info("[start] ClientController - editClient");
        clientService.editClient(idClient, editClientRequest);
        log.info("[finish] ClientController - editClient");
    }
}
