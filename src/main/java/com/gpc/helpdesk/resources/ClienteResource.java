package com.gpc.helpdesk.resources;

import com.gpc.helpdesk.dtos.ClienteDTO;
import com.gpc.helpdesk.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value ="/clientes")
public class ClienteResource {

    @Autowired
    ClienteService serviceCliente;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(serviceCliente.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){
        return ResponseEntity.ok().body(serviceCliente.finAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO ClienteDTO){
        ClienteDTO clienteCreated = serviceCliente.save(ClienteDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(clienteCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteCreated);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@RequestParam Long id,@Valid @RequestBody ClienteDTO ClienteDTO){
        ClienteDTO cliente = serviceCliente.update(id, ClienteDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteDTO> delete(@PathVariable Long id) {
        serviceCliente.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
