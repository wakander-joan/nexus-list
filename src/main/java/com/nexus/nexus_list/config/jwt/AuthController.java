package com.nexus.nexus_list.config.jwt;

import com.nexus.nexus_list.config.jwt.AuthRequest;
import com.nexus.nexus_list.config.jwt.JwtService;
import com.nexus.nexus_list.handler.APIException;
import com.nexus.nexus_list.user.application.repository.ClientRepository;
import com.nexus.nexus_list.user.domain.Client;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Log4j2
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final ClientRepository clientRepository;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthRequest request) {
        log.info("Tentativa de login para: {}", request.getEmail());

        // Autentica credenciais — lança exceção se inválido
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw APIException.build(HttpStatus.UNAUTHORIZED, "Password erro!");
        } catch (UsernameNotFoundException e) {
            throw APIException.build(HttpStatus.NOT_FOUND, "Email not registered!");
        }

        // Carrega UserDetails e gera o token
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtService.generateToken(userDetails);

        // Busca dados extras do Client para retornar no response
        Client client = clientRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Client Not Found!"));
        log.info("Login realizado com sucesso: {}", request.getEmail());

        return ResponseEntity.ok(AuthResponse.builder()
                .token(token)
                .email(client.getEmail())
                .name(client.getName())
                .build());
    }
}