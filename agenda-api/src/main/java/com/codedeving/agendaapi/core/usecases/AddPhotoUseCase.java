package com.codedeving.agendaapi.core.usecases;

import jakarta.servlet.http.Part;

public interface AddPhotoUseCase {

    public byte[] execute(Integer id, Part arquivo);
}
