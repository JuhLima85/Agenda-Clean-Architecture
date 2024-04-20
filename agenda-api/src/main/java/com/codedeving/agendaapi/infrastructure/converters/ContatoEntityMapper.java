package com.codedeving.agendaapi.infrastructure.converters;

import com.codedeving.agendaapi.core.domain.Contato;
import com.codedeving.agendaapi.infrastructure.persistence.entities.ContatoEntity;
import org.springframework.stereotype.Component;

@Component
public class ContatoEntityMapper {

    public ContatoEntity toEntity(Contato contato){
        return new ContatoEntity(contato.id(), contato.nome(), contato.email(), contato.favorito());
    }

    public Contato toContato(ContatoEntity entity){
        return new Contato(entity.getId(), entity.getNome(), entity.getEmail(), entity.getFavorito());
    }
}
