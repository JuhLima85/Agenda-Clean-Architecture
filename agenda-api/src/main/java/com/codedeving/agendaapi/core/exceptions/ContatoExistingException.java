package com.codedeving.agendaapi.core.exceptions;

public class ContatoExistingException extends RuntimeException{

    public ContatoExistingException(){
        super("Este contato já existe!");
    }

    public ContatoExistingException(String mensage){
        super(mensage);
    }
}
