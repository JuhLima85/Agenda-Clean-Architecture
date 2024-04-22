package com.codedeving.agendaapi.core.gateways;

import com.codedeving.agendaapi.core.domain.Contato;

import java.util.List;
import java.util.Optional;

public interface ContatoGateway {

    Contato createContato(Contato contato);

    void deleteContato(Integer id);

    List<Contato> obtainAllContatos();

    void favoriteContato(Integer id, Boolean favorito);

    Contato updateContato(Integer id, Contato contato);
}