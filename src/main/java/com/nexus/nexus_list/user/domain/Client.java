package com.nexus.nexus_list.user.domain;

import com.nexus.nexus_list.user.application.api.ClientRequest;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor
@Log4j2
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idUser;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    // Armazena apenas o caminho/key do S3
    private String imgProfileKey;

    public Client(ClientRequest clientRequest) {
        this.name = clientRequest.getName();
        this.email = clientRequest.getEmail();
        this.password = new BCryptPasswordEncoder().encode(clientRequest.getPassword());
        this.imgProfileKey =  clientRequest.getImgProfileKey();
    }
}