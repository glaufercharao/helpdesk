package com.gpc.helpdesk.services;

import com.gpc.helpdesk.domain.Tecnico;
import com.gpc.helpdesk.repositories.TecnicoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRespository respository;

    public TecnicoService(){

    }

    public Tecnico findById(Long id){
        Optional<Tecnico> tecnico = respository.findById(id);
        return tecnico.orElse(null);
    }
}
