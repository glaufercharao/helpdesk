package com.gpc.helpdesk.resources;

import com.gpc.helpdesk.domain.Tecnico;
import com.gpc.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/tecnicos")
public class TecnicoResource {

    @Autowired
    TecnicoService serviceTecnico;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tecnico> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(serviceTecnico.findById(id));
    }
}
