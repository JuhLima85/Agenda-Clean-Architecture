package com.codedeving.agendaapi.infrastructure.converters;

import com.codedeving.agendaapi.core.domain.Contato;
import com.codedeving.agendaapi.infrastructure.dtos.ContatoDto;
import org.springframework.stereotype.Component;

@Component
public class ContatoDtoMapper {

    public ContatoDto toDTO(Contato contato){
        return new ContatoDto(contato.nome(), contato.email(), contato.favorito());
    }

    public Contato toDomain(ContatoDto contatoDto){
        return new Contato(null, contatoDto.nome(), contatoDto.email(), contatoDto.favorito());
    }

}
