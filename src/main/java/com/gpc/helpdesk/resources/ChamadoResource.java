package com.gpc.helpdesk.resources;

import com.gpc.helpdesk.dtos.ChamadoDTO;
import com.gpc.helpdesk.dtos.ClienteDTO;
import com.gpc.helpdesk.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
