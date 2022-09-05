package com.gpc.helpdesk.repositories;

import com.gpc.helpdesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRespository extends JpaRepository<Tecnico, Long> {
}
