package com.codedeving.agendaapi.core.usecases;

import com.codedeving.agendaapi.core.gateways.ContatoGateway;

public class FavoriteContatoUseCaseImpl implements FavoriteContatoUseCase{
    private final ContatoGateway contatoGateway;

    public FavoriteContatoUseCaseImpl(ContatoGateway contatoGateway) {
        this.contatoGateway = contatoGateway;
    }

    @Override
    public void execute(Integer id) {
        contatoGateway.favoriteContato(id);
    }
}
