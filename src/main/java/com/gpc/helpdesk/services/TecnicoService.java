package com.gpc.helpdesk.services;

import com.gpc.helpdesk.domain.Tecnico;
import com.gpc.helpdesk.dtos.TecnicoDTO;
import com.gpc.helpdesk.exception.standard.ObjectNotFoundException;
import com.gpc.helpdesk.mapper.Mappable;
import com.gpc.helpdesk.repositories.TecnicoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService implements Mappable {

    @Autowired
    private TecnicoRespository respository;

    public TecnicoService(){

    }

    public TecnicoDTO findById(Long id) {
        return map(respository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado! ID: "+ id)), TecnicoDTO.class);
    }

    public List<TecnicoDTO> finAll() {
        return map(respository.findAll(), TecnicoDTO.class);
    }

    public TecnicoDTO save(TecnicoDTO tecnicoDTO) {
        return  map(respository.save(map(tecnicoDTO, Tecnico.class)), TecnicoDTO.class);
    }
}
