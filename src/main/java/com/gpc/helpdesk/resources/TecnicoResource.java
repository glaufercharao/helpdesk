package com.gpc.helpdesk.resources;

import com.gpc.helpdesk.domain.Tecnico;
import com.gpc.helpdesk.dtos.TecnicoDTO;
import com.gpc.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/tecnicos")
public class TecnicoResource {

    @Autowired
    TecnicoService serviceTecnico;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(serviceTecnico.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll(){
        return ResponseEntity.ok().body(serviceTecnico.finAll());
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO tecnicoDTO){
        TecnicoDTO tecnicoCreated = serviceTecnico.save(tecnicoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(tecnicoCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(tecnicoCreated);
    }
}
