package com.codedeving.agendaapi.infrastructure.dtos;

public record ContatoDto(Integer id,
                         String nome,
                         String email,
                         Boolean favorito,
                         byte[] foto) {
}
