package com.codedeving.agendaapi.core.usecases;

import com.codedeving.agendaapi.core.domain.Contato;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GetAllContatosUseCase {

    //public List<Contato> execute();
    public Page<Contato> execute(Integer pagina, Integer tamanhoPagina);

}
