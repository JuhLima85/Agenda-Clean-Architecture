package com.codedeving.agendaapi.core.usecases;

import com.codedeving.agendaapi.core.domain.Contato;

import com.codedeving.agendaapi.core.exceptions.ContatoNotFoundException;
import com.codedeving.agendaapi.core.gateways.ContatoGateway;

public class UpdateContatoUseCaseImpl implements UpdateContatoUseCase{

    private final ContatoGateway contatoGateway;

    public UpdateContatoUseCaseImpl(ContatoGateway contatoGateway) {
        this.contatoGateway = contatoGateway;
    }

    @Override
    public Contato execute(Integer id, Contato contato) {
        if(contato.nome() == null || contato.nome().isEmpty()){
            throw new ContatoNotFoundException("O campo 'Nome' é obrigatório.");
        } else if (contato.email() == null || contato.email().isEmpty()){
            throw new ContatoNotFoundException("O campo 'E-mail' é obrigatório.");
        }
        return contatoGateway.updateContato(id, contato);
    }
}
