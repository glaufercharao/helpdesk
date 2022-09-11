package com.gpc.helpdesk.services;

import com.gpc.helpdesk.domain.Pessoa;
import com.gpc.helpdesk.domain.Tecnico;
import com.gpc.helpdesk.dtos.TecnicoDTO;
import com.gpc.helpdesk.exception.standard.DataIntegrityViolationException;
import com.gpc.helpdesk.exception.standard.ObjectNotFoundException;
import com.gpc.helpdesk.mapper.Mappable;
import com.gpc.helpdesk.repositories.PessoaRespository;
import com.gpc.helpdesk.repositories.TecnicoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService implements Mappable {

    @Autowired
    private TecnicoRespository respository;

    @Autowired
    private PessoaRespository pessoaRespository;

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
        validCpfAndEmail(tecnicoDTO);
        return  map(respository.save(map(tecnicoDTO, Tecnico.class)), TecnicoDTO.class);
    }

    public TecnicoDTO update(Long id, TecnicoDTO tecnicoDTO) {
        tecnicoDTO.setId(id);
        Optional<Tecnico> oldTecnico = respository.findById(id);

        if (oldTecnico.isPresent()) {
            validCpfAndEmail(tecnicoDTO);
            return map(respository.save(map(tecnicoDTO, Tecnico.class)), TecnicoDTO.class);
        }
       return null;
    }

    private void validCpfAndEmail(TecnicoDTO tecnicoDTO) {
        Optional<Pessoa> pessoa = pessoaRespository.findByCpf(tecnicoDTO.getCpf());
        if(pessoa.isPresent() && pessoa.get().getId() != tecnicoDTO.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        pessoa = pessoaRespository.findByEmail(tecnicoDTO.getEmail());
        if(pessoa.isPresent() && pessoa.get().getId() != tecnicoDTO.getId()){
            throw new DataIntegrityViolationException("e-Mail ja cadastrado no sistema!");
        }
    }
}
