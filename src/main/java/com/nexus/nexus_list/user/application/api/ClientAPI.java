package com.nexus.nexus_list.user.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public interface ClientAPI {

    @PostMapping("/createClient")
    @ResponseStatus(code = HttpStatus.CREATED)
    ClientResponse createClient (@Valid @RequestBody ClientRequest clientRequest);

}