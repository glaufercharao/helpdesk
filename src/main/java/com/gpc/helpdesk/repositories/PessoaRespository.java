package com.gpc.helpdesk.repositories;

import com.gpc.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRespository extends JpaRepository<Pessoa, Long> {
}
