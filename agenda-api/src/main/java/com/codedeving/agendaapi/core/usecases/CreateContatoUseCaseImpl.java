package com.codedeving.agendaapi.core.usecases;

import com.codedeving.agendaapi.core.domain.Contato;
import com.codedeving.agendaapi.core.exceptions.ContatoExistingException;
import com.codedeving.agendaapi.core.gateways.ContatoGateway;

public class CreateContatoUseCaseImpl implements CreateContatoUseCase{

    private final ContatoGateway contatoGateway;

    public CreateContatoUseCaseImpl(ContatoGateway contatoGateway) {
        this.contatoGateway = contatoGateway;
    }

    @Override
    public Contato execute(Contato contato) {
        Contato contatoExistente = contatoGateway.findByEmail(contato.email());
        if(contatoExistente != null){
            throw new ContatoExistingException("Já existe um contato com e-mail '" + contato.email() + "' cadastrado!");
        }
        return contatoGateway.createContato(contato);
    }
}
