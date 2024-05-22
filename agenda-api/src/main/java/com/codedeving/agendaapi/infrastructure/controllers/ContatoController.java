package com.codedeving.agendaapi.infrastructure.controllers;

import com.codedeving.agendaapi.core.domain.Contato;
import com.codedeving.agendaapi.core.usecases.*;
import com.codedeving.agendaapi.infrastructure.converters.ContatoDtoMapper;
import com.codedeving.agendaapi.infrastructure.dtos.ContatoDto;
import jakarta.servlet.http.Part;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/contatos")
@AllArgsConstructor
@CrossOrigin("*")
public class ContatoController {

    private final CreateContatoUseCase createContatoUseCase;
    private final ContatoDtoMapper contatoDtoMapper;
    private final DeleteContatoUseCase deleteContatoUseCase;
    private final GetAllContatosUseCase getAllContatosUseCase;
    private final FavoriteContatoUseCase favoriteContatoUseCase;
    private final UpdateContatoUseCase updateContatoUseCase;
    private final AddPhotoUseCase addPhotoUseCase;
    private final GetContatoByIdUseCase getContatoByIdUseCase;

    @PostMapping
    public ContatoDto createContato(@RequestBody ContatoDto contatoDto){
        Contato contato = createContatoUseCase.execute(contatoDtoMapper.toDomain(contatoDto));
        return contatoDtoMapper.toDTO(contato);
    }

    @DeleteMapping("/{id}")
    public void deleteContato(@PathVariable Integer id){
        deleteContatoUseCase.execute(id);
    }

    @GetMapping("/{id}")
    public ContatoDto buscarContato(@PathVariable Integer id){
        Contato contato = getContatoByIdUseCase.execute(id);
        return contatoDtoMapper.toDTO(contato);
    }
    @GetMapping
    public Page<ContatoDto> obtainAll(@RequestParam(value = "page", defaultValue = "0") Integer pagina,
                                      @RequestParam(value = "size", defaultValue = "10") Integer tamanhoPagina) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina);
        return getAllContatosUseCase.execute(pagina, tamanhoPagina)
                .map(contatoDtoMapper::toDTO);
    }

    @PatchMapping("/{id}/favorito")
    public void favorite(@PathVariable Integer id){
        favoriteContatoUseCase.execute(id);
    }

    @PutMapping("{id}")
    public ContatoDto updateContato(@PathVariable Integer id, @RequestBody ContatoDto contatoDto){
        System.out.println("Contato: " + contatoDto);
        Contato contato = updateContatoUseCase.execute(id, contatoDtoMapper.toDomain(contatoDto));
        return contatoDtoMapper.toDTO(contato);
    }

    @PutMapping("{id}/foto")
    public byte[] addPhoto(@PathVariable Integer id, @RequestParam("foto") Part arquivo){
        return addPhotoUseCase.execute(id, arquivo);
    }

}
