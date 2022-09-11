package com.gpc.helpdesk.resources;

import com.gpc.helpdesk.dtos.TecnicoDTO;
import com.gpc.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO tecnicoDTO){
        TecnicoDTO tecnicoCreated = serviceTecnico.save(tecnicoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(tecnicoCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(tecnicoCreated);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> update(@RequestParam Long id,@Valid @RequestBody TecnicoDTO tecnicoDTO){
        TecnicoDTO tecnico = serviceTecnico.update(id, tecnicoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(tecnico.getId()).toUri();
        return ResponseEntity.created(uri).body(tecnico);
    }
}
