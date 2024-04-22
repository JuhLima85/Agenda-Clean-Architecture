package com.codedeving.agendaapi.core.exceptions;

import org.apache.catalina.User;

public class ContatoNotFoundException extends RuntimeException{

    public ContatoNotFoundException(){
        super("Contato não encontrado!");
    }

    public ContatoNotFoundException(String message){
        super(message);
    }
}
