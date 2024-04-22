package com.codedeving.agendaapi.infrastructure.controllers;

import com.codedeving.agendaapi.core.domain.Contato;
import com.codedeving.agendaapi.core.usecases.*;
import com.codedeving.agendaapi.infrastructure.converters.ContatoDtoMapper;
import com.codedeving.agendaapi.infrastructure.dtos.ContatoDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/contatos")
@AllArgsConstructor
public class ContatoController {

    private final CreateContatoUseCase createContatoUseCase;
    private final ContatoDtoMapper contatoDtoMapper;
    private final DeleteContatoUseCase deleteContatoUseCase;
    private final GetAllContatosUseCase getAllContatosUseCase;
    private final FavoriteContatoUseCase favoriteContatoUseCase;
    private final UpdateContatoUseCase updateContatoUseCase;

    @PostMapping
    public ContatoDto createContato(@RequestBody ContatoDto contatoDto){
        Contato contato = createContatoUseCase.execute(contatoDtoMapper.toDomain(contatoDto));
        return contatoDtoMapper.toDTO(contato);
    }

    @DeleteMapping("/{id}")
    public void deleteContato(@PathVariable Integer id){
        deleteContatoUseCase.execute(id);
    }

    @GetMapping
    public List<ContatoDto> obtainAll(){
        return getAllContatosUseCase
                .execute()
                .stream()
                .map(contatoDtoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PatchMapping("/{id}/favorito")
    public void favorite(@PathVariable Integer id, @RequestBody Boolean favorito){
        favoriteContatoUseCase.execute(id, favorito);
    }

    @PutMapping("{id}")
    public ContatoDto updateContato(@PathVariable Integer id, @RequestBody ContatoDto contatoDto){
        Contato contato = updateContatoUseCase.execute(id, contatoDtoMapper.toDomain(contatoDto));
        return contatoDtoMapper.toDTO(contato);
    }

}
