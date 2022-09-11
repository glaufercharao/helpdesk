package com.gpc.helpdesk.resources;

import com.gpc.helpdesk.dtos.ChamadoDTO;
import com.gpc.helpdesk.dtos.ClienteDTO;
import com.gpc.helpdesk.dtos.TecnicoDTO;
import com.gpc.helpdesk.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoResource {

    @Autowired
    public ChamadoService chamadoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ChamadoDTO>  findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(chamadoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ChamadoDTO>> findAll(){
        return ResponseEntity.ok().body(chamadoService.findAll());
    }

    @PostMapping
    public ResponseEntity<ChamadoDTO> create(@Valid @RequestBody ChamadoDTO chamadoDTO){
        ChamadoDTO  chamadoCreated = chamadoService.save(chamadoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(chamadoCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(chamadoCreated);
    }
}
