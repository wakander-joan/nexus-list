package com.nexus.nexus_list.user.application.api;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class EditClientRequest {
    private String name;
    private String email;
    private String imgProfileKey;
}
