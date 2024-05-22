package com.codedeving.agendaapi.core.gateways;

import com.codedeving.agendaapi.core.domain.Contato;
import jakarta.servlet.http.Part;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContatoGateway {

    Contato createContato(Contato contato);

    Contato findByEmail(String email);

    void deleteContato(Integer id);

    //List<Contato> obtainAllContatos();

    Page<Contato> obtainAllContatos(Integer pagina, Integer tamanhoPagina);

   Contato obterContatoPorId(Integer id);

    void favoriteContato(Integer id);

    Contato updateContato(Integer id, Contato contato);

    byte[] addPhoto(Integer id, Part arquivo);
}