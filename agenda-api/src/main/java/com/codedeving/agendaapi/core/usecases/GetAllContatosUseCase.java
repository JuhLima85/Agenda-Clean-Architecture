package com.codedeving.agendaapi.core.usecases;

import com.codedeving.agendaapi.core.domain.Contato;

import java.util.List;

public interface GetAllContatosUseCase {

    public List<Contato> execute();
}
