package com.codedeving.agendaapi.infrastructure.persistence.repository;

import com.codedeving.agendaapi.infrastructure.persistence.entities.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    ContatoEntity findByEmail(String email);
}
