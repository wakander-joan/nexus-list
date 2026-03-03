package com.nexus.nexus_list.user.application.repository;

import com.nexus.nexus_list.user.domain.Client;

import java.util.UUID;

public interface ClientRepository {
    Client save(Client client);
    Client getClient(UUID idClient);
}
