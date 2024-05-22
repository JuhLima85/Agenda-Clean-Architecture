package com.codedeving.agendaapi.core.usecases;

import com.codedeving.agendaapi.core.gateways.ContatoGateway;
import jakarta.servlet.http.Part;

public class AddPhotoUseCaseImpl implements AddPhotoUseCase{

    private final ContatoGateway contatoGateway;

    public AddPhotoUseCaseImpl(ContatoGateway contatoGateway) {
        this.contatoGateway = contatoGateway;
    }

    @Override
    public byte[] execute(Integer id, Part arquivo) {
        return contatoGateway.addPhoto(id, arquivo);
    }
}
