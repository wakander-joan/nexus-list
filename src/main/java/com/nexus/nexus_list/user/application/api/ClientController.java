package com.nexus.nexus_list.user.application.api;

import com.nexus.nexus_list.user.application.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

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
}
