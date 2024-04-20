package com.codedeving.agendaapi.core.usecases;

import com.codedeving.agendaapi.core.gateways.ContatoGateway;

public class DeleteContatoUseCaseImpl implements DeleteContatoUseCase{

    private final ContatoGateway contatoGateway;

    public DeleteContatoUseCaseImpl(ContatoGateway contatoGateway) {
        this.contatoGateway = contatoGateway;
    }

    @Override
    public void execute(Integer id) {
        contatoGateway.deleteContato(id);
    }
}
