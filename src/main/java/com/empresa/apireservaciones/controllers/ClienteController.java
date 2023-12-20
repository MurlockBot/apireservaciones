package com.empresa.apireservaciones.controllers;


import com.empresa.apireservaciones.dto.ClienteRequest;
import com.empresa.apireservaciones.dto.ClienteRequestUpdate;
import com.empresa.apireservaciones.services.ClienteServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    private final ClienteServiceImpl clienteService;

    public ClienteController(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCliente(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.read(id));
    }

    @PostMapping
    public ResponseEntity<?> postCliente(@RequestBody @Valid ClienteRequest cliente) {
        return ResponseEntity.ok(clienteService.create(cliente));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> putCliente(@PathVariable Long id, @RequestBody @Valid ClienteRequestUpdate cliente) {
        return ResponseEntity.ok(clienteService.update(cliente, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id) {
        clienteService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
