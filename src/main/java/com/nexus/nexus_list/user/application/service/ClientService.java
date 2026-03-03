package com.nexus.nexus_list.user.application.service;

import com.nexus.nexus_list.user.application.api.ClientDetailedResponse;
import com.nexus.nexus_list.user.application.api.ClientRequest;
import com.nexus.nexus_list.user.application.api.ClientResponse;
import com.nexus.nexus_list.user.application.api.EditClientRequest;

import java.util.UUID;

public interface ClientService {
    ClientResponse createClient(ClientRequest clientRequest);
    ClientDetailedResponse getClient(UUID idClient);
    void editClient(UUID idClient, EditClientRequest editClientRequest);
}
