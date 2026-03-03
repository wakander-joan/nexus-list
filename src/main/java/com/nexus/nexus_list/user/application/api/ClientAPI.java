package com.nexus.nexus_list.user.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public interface ClientAPI {

    @PostMapping("/createClient")
    @ResponseStatus(code = HttpStatus.CREATED)
    ClientResponse createClient (@Valid @RequestBody ClientRequest clientRequest);

    @GetMapping("/getClient/{idClient}")
    @ResponseStatus(code = HttpStatus.OK)
    ClientDetailedResponse getClient(@PathVariable UUID idClient);

    @PatchMapping(value = "/editClient/{idClient}")
    @ResponseStatus(code = HttpStatus.OK)
    void editClient (@PathVariable UUID idClient, @Valid @RequestBody EditClientRequest editClientRequest);

}