package com.codedeving.agendaapi.core.usecases;

import com.codedeving.agendaapi.core.domain.Contato;
import com.codedeving.agendaapi.core.gateways.ContatoGateway;

import java.util.List;

public class GetAllContatosUseCaseImpl implements GetAllContatosUseCase{

    private final ContatoGateway contatoGateway;

    public GetAllContatosUseCaseImpl(ContatoGateway contatoGateway) {
        this.contatoGateway = contatoGateway;
    }

    @Override
    public List<Contato> execute() {
        return contatoGateway.obtainAllContatos();
    }
}

