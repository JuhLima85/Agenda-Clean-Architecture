package com.codedeving.agendaapi.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name - "TB_CONTATO")
public class ContatoEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String email;
    private Boolean favorito;
}
