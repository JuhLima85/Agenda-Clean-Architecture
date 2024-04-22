package com.codedeving.agendaapi.infrastructure.exceptions;


import com.codedeving.agendaapi.core.exceptions.ContatoExistingException;
import com.codedeving.agendaapi.core.exceptions.ContatoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ContatoNotFoundException.class)
    private ResponseEntity<RestErrorMessage> contatoNotFoundException(ContatoNotFoundException e){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(ContatoExistingException.class)
    private ResponseEntity<RestErrorMessage> contatoExistingException(ContatoExistingException e){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.CONFLICT, e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

}
