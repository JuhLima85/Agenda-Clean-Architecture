package com.codedeving.agendaapi.core.usecases;

import com.codedeving.agendaapi.core.domain.Contato;

public interface UpdateContatoUseCase {

    public Contato execute(Integer id, Contato contato);
}
