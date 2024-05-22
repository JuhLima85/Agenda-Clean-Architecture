package com.codedeving.agendaapi.infrastructure.gateways;

import com.codedeving.agendaapi.core.domain.Contato;
import com.codedeving.agendaapi.core.gateways.ContatoGateway;
import com.codedeving.agendaapi.infrastructure.converters.ContatoEntityMapper;
import com.codedeving.agendaapi.core.exceptions.ContatoNotFoundException;
import com.codedeving.agendaapi.infrastructure.persistence.entities.ContatoEntity;
import com.codedeving.agendaapi.infrastructure.persistence.repository.ContatoRepository;
import jakarta.servlet.http.Part;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

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
    public Contato findByEmail(String email) {
        ContatoEntity entity = contatoRepository.findByEmail(email);
        if (entity == null){
            return null;
        }
        return entityMapper.toContato(entity);
    }

    @Override
    public void deleteContato(Integer id) {
        contatoRepository.deleteById(id);
    }

    @Override
    public Page<Contato> obtainAllContatos(Integer pagina, Integer tamanhoPagina) {
        Sort sort = Sort.by(Sort.Direction.ASC, "nome");
        PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina, sort);
        return contatoRepository
                .findAll(pageRequest)
                .map(entityMapper::toContato);
    }

    @Override
    public Contato obterContatoPorId(Integer id) {
        return contatoRepository.findById(id)
                .map(entityMapper::toContato)
                .orElseThrow(() -> new ContatoNotFoundException("Contato não encontrado"));
    }

    @Override
    public void favoriteContato(Integer id) {
        Optional<ContatoEntity> contatoEntity = contatoRepository.findById(id);
        contatoEntity.ifPresent(c -> {
            boolean favorito = c.getFavorito() == Boolean.TRUE;
            c.setFavorito(!favorito);
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

    @Override
    public byte[] addPhoto(Integer id, Part arquivo) {
        Optional<ContatoEntity> contatoEntity = contatoRepository.findById(id);
       return contatoEntity.map( c -> {
            try{
                InputStream is = arquivo.getInputStream();
                byte[] bytes = new byte[(int) arquivo.getSize()];
                IOUtils.readFully(is, bytes);
                c.setFoto(bytes);
                contatoRepository.save(c);
                is.close();
                return bytes;
            }catch (IOException e){
                return null;
            }
        }).orElse(null);
    }
}
