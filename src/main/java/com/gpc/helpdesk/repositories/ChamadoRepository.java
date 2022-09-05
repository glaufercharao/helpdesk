package com.gpc.helpdesk.repositories;

import com.gpc.helpdesk.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository  extends JpaRepository<Chamado, Long> {
}
