package com.codedeving.agendaapi.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "TB_CONTATO")
public class ContatoEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String email;
    private Boolean favorito;
    @Column(columnDefinition = "LONGBLOB", length = 16777215)
    private byte[] foto;
}
