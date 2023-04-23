package com.pds.planit.entity;

import jakarta.persistence.*;

@Entity
@Table(name="projeto")
public class Projeto {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nome")
    private String nome;

    @Column(name="andamento")
    private float andamento;

    //define constructor
    public Projeto() {
        this.andamento = 0;
    }

    public Projeto(String nome) {
        this.nome = nome;
        this.andamento = 0;
    }

    //define getters and setters


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAndamento(float andamento) {
        this.andamento = andamento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAndamento() {
        return andamento;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}