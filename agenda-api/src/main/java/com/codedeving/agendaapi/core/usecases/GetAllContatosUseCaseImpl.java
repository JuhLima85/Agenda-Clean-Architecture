package com.codedeving.agendaapi.core.usecases;

import com.codedeving.agendaapi.core.domain.Contato;
import com.codedeving.agendaapi.core.gateways.ContatoGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class GetAllContatosUseCaseImpl implements GetAllContatosUseCase{

    private final ContatoGateway contatoGateway;

    public GetAllContatosUseCaseImpl(ContatoGateway contatoGateway) {
        this.contatoGateway = contatoGateway;
    }

    //    @Override
//    public List<Contato> execute() {
//        return contatoGateway.obtainAllContatos();
//    }

    @Override
    public Page<Contato> execute(Integer pagina, Integer tamanhoPagina) {
        return contatoGateway.obtainAllContatos(pagina, tamanhoPagina);
    }

}

