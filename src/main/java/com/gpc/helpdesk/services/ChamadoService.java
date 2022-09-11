package com.gpc.helpdesk.services;

import com.gpc.helpdesk.domain.Chamado;
import com.gpc.helpdesk.dtos.ChamadoDTO;
import com.gpc.helpdesk.dtos.ClienteDTO;
import com.gpc.helpdesk.dtos.TecnicoDTO;
import com.gpc.helpdesk.exception.standard.ObjectNotFoundException;
import com.gpc.helpdesk.mapper.Mappable;
import com.gpc.helpdesk.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService implements Mappable {
    @Autowired
    public ChamadoRepository chamadoRepository;

    public ChamadoDTO findById(Long id) {
        return map(chamadoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado! ID: "+ id)), ChamadoDTO.class);
    }

    public List<ChamadoDTO> findAll() {
        return map(chamadoRepository.findAll(), ChamadoDTO.class);
    }
}
