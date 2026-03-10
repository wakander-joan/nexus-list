package com.nexus.nexus_list.user.application.repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.nexus.nexus_list.user.domain.Client;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository {
    Client save(Client client);
    Client getClient(UUID idClient);
    Optional<Client> findByEmail(String email);
}
