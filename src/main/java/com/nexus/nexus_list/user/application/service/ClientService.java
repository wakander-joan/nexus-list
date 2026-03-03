package com.nexus.nexus_list.user.application.service;

import com.nexus.nexus_list.user.application.api.ClientRequest;
import com.nexus.nexus_list.user.application.api.ClientResponse;

public interface ClientService {
    ClientResponse createClient(ClientRequest clientRequest);
}
