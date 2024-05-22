package com.codedeving.agendaapi.core.usecases;

import com.codedeving.agendaapi.core.domain.Contato;
import com.codedeving.agendaapi.core.gateways.ContatoGateway;

public class GetContatoByIdUseCaseImpl implements GetContatoByIdUseCase{

    private final ContatoGateway contatoGateway;

    public GetContatoByIdUseCaseImpl(ContatoGateway contatoGateway) {
        this.contatoGateway = contatoGateway;
    }

    @Override
    public Contato execute(Integer id) {
        return contatoGateway.obterContatoPorId(id);
    }
}
