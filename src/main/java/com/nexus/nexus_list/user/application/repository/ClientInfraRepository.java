package com.nexus.nexus_list.user.application.repository;

import com.nexus.nexus_list.handler.APIException;
import com.nexus.nexus_list.user.domain.Client;
import com.nexus.nexus_list.user.infra.ClientSpringDataJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClientInfraRepository implements ClientRepository {
    private final ClientSpringDataJPARepository clientSpringDataJPARepository;

    @Override
    public Client save(Client client) {
        log.info("[start] ClientInfraRepository - save");
        Client clientSalvo = clientSpringDataJPARepository.save(client);
        log.info("[finish] ClientInfraRepository - save");
        return clientSalvo;
    }

    @Override
    public Client getClient(UUID idClient) {
        log.info("[start] ClientInfraRepository - getClient");
        Client clientBuscado = clientSpringDataJPARepository.findById(idClient)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Client Not Found!"));
        log.info("[finish] ClientInfraRepository - getClient");
        return clientBuscado;
    }
}
