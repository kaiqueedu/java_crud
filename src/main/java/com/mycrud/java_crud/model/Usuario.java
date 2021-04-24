package com.mycrud.java_crud.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private Integer idade;
    private String telefone;
    private String sexo;

    public Usuario(String nome, Integer idade, String telefone, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.sexo = sexo;
    }

    public Usuario() {}
}
