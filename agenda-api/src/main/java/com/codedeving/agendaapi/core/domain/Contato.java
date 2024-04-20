package com.codedeving.agendaapi.core.entities;

public record Contato(Integer id,
                      String nome,
                      String email,
                      Boolean favorito) {}
