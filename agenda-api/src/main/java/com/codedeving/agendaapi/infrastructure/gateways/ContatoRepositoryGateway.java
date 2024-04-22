package com.codedeving.agendaapi.infrastructure.gateways;

import com.codedeving.agendaapi.core.domain.Contato;
import com.codedeving.agendaapi.core.gateways.ContatoGateway;
import com.codedeving.agendaapi.infrastructure.converters.ContatoEntityMapper;
import com.codedeving.agendaapi.core.exceptions.ContatoNotFoundException;
import com.codedeving.agendaapi.infrastructure.persistence.entities.ContatoEntity;
import com.codedeving.agendaapi.infrastructure.persistence.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContatoRepositoryGateway implements ContatoGateway {

    private final ContatoRepository contatoRepository;
    private final ContatoEntityMapper entityMapper;

    @Override
    public Contato createContato(Contato contato) {
        ContatoEntity entity = entityMapper.toEntity(contato);
        ContatoEntity novoContato = contatoRepository.save(entity);
        return entityMapper.toContato(novoContato);
    }

    @Override
    public void deleteContato(Integer id) {
        contatoRepository.deleteById(id);
    }

    @Override
    public List<Contato> obtainAllContatos() {
        return contatoRepository
                .findAll()
                .stream()
                .map(entityMapper::toContato)
                .collect(Collectors.toList());
    }

    @Override
    public void favoriteContato(Integer id, Boolean favorito) {
        Optional<ContatoEntity> contatoEntity = contatoRepository.findById(id);
        contatoEntity.ifPresent(c -> {
            c.setFavorito(favorito);
            contatoRepository.save(c);
        });
    }

    @Override
    public Contato updateContato(Integer id, Contato contato) {
        ContatoEntity entity = entityMapper.toEntity(contato);

        ContatoEntity existingEntity = contatoRepository.findById(id)
                .orElseThrow(() -> new ContatoNotFoundException("Contato não encontrado"));

        existingEntity.setNome(entity.getNome());
        existingEntity.setEmail(entity.getEmail());
        existingEntity.setFavorito(entity.getFavorito());

        ContatoEntity contatoUpdate = contatoRepository.save(existingEntity);
        return entityMapper.toContato(contatoUpdate);
    }

}
