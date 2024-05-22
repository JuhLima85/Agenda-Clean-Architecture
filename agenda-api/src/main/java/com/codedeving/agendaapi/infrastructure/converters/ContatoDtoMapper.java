package com.codedeving.agendaapi.infrastructure.converters;

import com.codedeving.agendaapi.core.domain.Contato;
import com.codedeving.agendaapi.infrastructure.dtos.ContatoDto;
import org.springframework.stereotype.Component;

@Component
public class ContatoDtoMapper {

    public ContatoDto toDTO(Contato contato){
        return new ContatoDto(contato.id(), contato.nome(), contato.email(), contato.favorito(), contato.foto());
    }

    public Contato toDomain(ContatoDto contatoDto){
        return new Contato(contatoDto.id(), contatoDto.nome(), contatoDto.email(), contatoDto.favorito(), contatoDto.foto());
    }

}
