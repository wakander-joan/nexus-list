package com.nexus.nexus_list.user.application.api;

import com.nexus.nexus_list.user.domain.Client;
import jakarta.persistence.Column;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ClientDetailedResponse {
    private UUID idUser;
    private String name;
    private String email;
    private String imgProfileKey;

    public ClientDetailedResponse(Client clientBuscado) {
        this.idUser = clientBuscado.getIdUser();
        this.name = clientBuscado.getName();
        this.email = clientBuscado.getEmail();
        this.imgProfileKey = clientBuscado.getImgProfileKey();
    }

}
