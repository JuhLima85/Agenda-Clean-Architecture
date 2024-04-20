package com.codedeving.agendaapi.core.gateways;

import com.codedeving.agendaapi.core.domain.Contato;

import java.util.List;

public interface ContatoGateway {

    Contato createContato(Contato contato);

    void deleteContato(Integer id);

    List<Contato> obtainAllContatos();

    void favoriteContato(Integer id, Boolean favorito);
}
