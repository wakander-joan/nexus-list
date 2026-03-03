package com.nexus.nexus_list.user.application.api;

import com.nexus.nexus_list.user.domain.Client;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ClientResponse {
    private UUID idClient;

    public ClientResponse(Client client) {
        this.idClient = client.getIdUser();
    }
}
