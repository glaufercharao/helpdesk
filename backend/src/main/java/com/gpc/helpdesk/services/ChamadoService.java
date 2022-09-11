package com.gpc.helpdesk.services;

import com.gpc.helpdesk.domain.Chamado;
import com.gpc.helpdesk.domain.Cliente;
import com.gpc.helpdesk.domain.Tecnico;
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
    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ClienteService clienteService;

    public ChamadoDTO findById(Long id) {
        return map(chamadoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado! ID: "+ id)), ChamadoDTO.class);
    }

    public List<ChamadoDTO> findAll() {
        return map(chamadoRepository.findAll(), ChamadoDTO.class);
    }

    public ChamadoDTO save(ChamadoDTO chamadoDTO) {
        return  map(chamadoRepository.save(map(chamadoDTO, Chamado.class)), ChamadoDTO.class);
    }

//    private Chamado buildChamado(ChamadoDTO chamadoDTO){
//        Cliente cliente = map(clienteService.findById(chamadoDTO.getCliente()), Cliente.class);
//        Tecnico tecnico = map(tecnicoService.findById(chamadoDTO.getTecnico()), Tecnico.class);
//
//        Chamado chamado = new Chamado();
//        return chamado;
//    }


}
