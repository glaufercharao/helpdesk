package com.gpc.helpdesk.services;

import com.gpc.helpdesk.domain.Cliente;
import com.gpc.helpdesk.domain.Pessoa;
import com.gpc.helpdesk.dtos.ClienteDTO;
import com.gpc.helpdesk.exception.standard.DataIntegrityViolationException;
import com.gpc.helpdesk.exception.standard.ObjectNotFoundException;
import com.gpc.helpdesk.mapper.Mappable;
import com.gpc.helpdesk.repositories.ClienteRepository;
import com.gpc.helpdesk.repositories.PessoaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements Mappable {

    @Autowired
    private ClienteRepository respository;

    @Autowired
    private PessoaRespository pessoaRespository;

    public ClienteService(){

    }

    public ClienteDTO findById(Long id) {
        return map(respository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado! ID: "+ id)), ClienteDTO.class);
    }

    public List<ClienteDTO> findAll() {
        return map(respository.findAll(), ClienteDTO.class);
    }

    public ClienteDTO save(ClienteDTO clienteDTO) {
        validCpfAndEmail(clienteDTO);
        return  map(respository.save(map(clienteDTO, Cliente.class)), ClienteDTO.class);
    }

    public ClienteDTO update(Long id, ClienteDTO clienteDTO) {
        clienteDTO.setId(id);
        Optional<Cliente> oldCliente = respository.findById(id);

        if (oldCliente.isPresent()) {
            validCpfAndEmail(clienteDTO);
            return map(respository.save(map(clienteDTO, Cliente.class)), ClienteDTO.class);
        }
       return null;
    }

    private void validCpfAndEmail(ClienteDTO clienteDTO) {
        Optional<Pessoa> pessoa = pessoaRespository.findByCpf(clienteDTO.getCpf());
        if(pessoa.isPresent() && pessoa.get().getId() != clienteDTO.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        pessoa = pessoaRespository.findByEmail(clienteDTO.getEmail());
        if(pessoa.isPresent() && pessoa.get().getId() != clienteDTO.getId()){
            throw new DataIntegrityViolationException("e-Mail ja cadastrado no sistema!");
        }
    }

    public void deleteById(Long id) {
        Optional<Cliente> cliente = respository.findById(id);
        if (!cliente.isPresent()){
            throw new DataIntegrityViolationException("Tecnico não encontrado!");
        }

        if (cliente.get().getChamados().size() > 0) {
            throw new DataIntegrityViolationException("Tecnico possui ordens de serviço e não pode ser removido do sistema!");
        }
        respository.deleteById(id);
    }
}
