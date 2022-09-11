package com.gpc.helpdesk.services.impl;

import com.gpc.helpdesk.domain.Pessoa;
import com.gpc.helpdesk.repositories.PessoaRespository;
import com.gpc.helpdesk.security.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PessoaRespository pessoaRespository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Pessoa> pessoa = pessoaRespository.findByEmail(email);
        if (pessoa.isPresent()){
            return new UserSecurity(pessoa.get().getId(), pessoa.get().getEmail(),
                    pessoa.get().getSenha(), pessoa.get().getPerfis());
        }
        throw new UsernameNotFoundException(email);
    }
}
