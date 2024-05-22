package com.codedeving.agendaapi.core.usecases;

import com.codedeving.agendaapi.core.domain.Contato;

public interface GetContatoByIdUseCase {

    public Contato execute(Integer id);
}
