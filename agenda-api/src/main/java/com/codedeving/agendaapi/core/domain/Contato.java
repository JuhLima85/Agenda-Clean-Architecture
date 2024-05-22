package com.codedeving.agendaapi.core.domain;

public record Contato(Integer id,
                      String nome,
                      String email,
                      Boolean favorito,
                      byte[] foto) {}
