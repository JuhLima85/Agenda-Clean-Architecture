package com.codedeving.agendaapi.infrastructure.configuration;

import com.codedeving.agendaapi.core.gateways.ContatoGateway;
import com.codedeving.agendaapi.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreateContatoUseCase createContatoUseCase(ContatoGateway contatoGateway){
        return new CreateContatoUseCaseImpl(contatoGateway);
    }

    @Bean
    public DeleteContatoUseCase deleteContatoUseCase(ContatoGateway contatoGateway){
        return new DeleteContatoUseCaseImpl(contatoGateway);
    }

    @Bean
    public GetAllContatosUseCase getAllContatosUseCase(ContatoGateway contatoGateway){
        return new GetAllContatosUseCaseImpl(contatoGateway);
    }

    @Bean
    public GetContatoByIdUseCase getContatoByIdUseCase(ContatoGateway contatoGateway){
        return new GetContatoByIdUseCaseImpl(contatoGateway);
    }

    @Bean
    public FavoriteContatoUseCase favoriteContatoUseCase(ContatoGateway contatoGateway){
        return new FavoriteContatoUseCaseImpl(contatoGateway);
    }

    @Bean
    public UpdateContatoUseCase updateContatoUseCase(ContatoGateway contatoGateway){
        return  new UpdateContatoUseCaseImpl(contatoGateway);
    }

    @Bean
    public AddPhotoUseCase addPhotoUseCase(ContatoGateway contatoGateway){
        return new AddPhotoUseCaseImpl(contatoGateway);
    }
}
