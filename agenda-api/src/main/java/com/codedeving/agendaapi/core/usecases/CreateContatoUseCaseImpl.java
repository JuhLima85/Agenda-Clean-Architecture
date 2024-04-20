package com.codedeving.agendaapi.core.usecases;

import com.codedeving.agendaapi.core.domain.Contato;
import com.codedeving.agendaapi.core.gateways.ContatoGateway;

public class CreateContatoUseCaseImpl implements CreateContatoUseCase{

    private final ContatoGateway contatoGateway;

    public CreateContatoUseCaseImpl(ContatoGateway contatoGateway) {
        this.contatoGateway = contatoGateway;
    }

    @Override
    public Contato execute(Contato contato) {
        return contatoGateway.createContato(contato);
    }
}
