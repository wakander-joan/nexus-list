package com.nexus.nexus_list.user.application.service;

import com.nexus.nexus_list.user.application.api.ClientDetailedResponse;
import com.nexus.nexus_list.user.application.api.ClientRequest;
import com.nexus.nexus_list.user.application.api.ClientResponse;
import com.nexus.nexus_list.user.application.api.EditClientRequest;
import com.nexus.nexus_list.user.application.repository.ClientRepository;
import com.nexus.nexus_list.user.domain.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Log4j2
@Service
public class ClientApplicationService implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        log.info("[start] ClientApplicationService - createClient");
        //Valida E-mail
        Client client = clientRepository.save(new Client(clientRequest));
        log.info("[finish] ClientApplicationService - createClient");
        return new ClientResponse(client);
    }

    @Override
    public ClientDetailedResponse getClient(UUID idClient) {
        log.info("[start] ClientApplicationService - getClient");
        Client clientBuscado = clientRepository.getClient(idClient);
        log.info("[finish] ClientApplicationService - getClient");
        return new ClientDetailedResponse(clientBuscado);
    }

    @Override
    public void editClient(UUID idClient, EditClientRequest editClientRequest) {
        log.info("[start] ClientApplicationService - editClient");
        Client clientBuscado = clientRepository.getClient(idClient);
        clientBuscado.edit(clientBuscado, editClientRequest);
        clientRepository.save(clientBuscado);
        log.info("[finish] ClientApplicationService - editClient");
    }
}
