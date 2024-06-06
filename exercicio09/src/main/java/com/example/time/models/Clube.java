package com.example.time.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "clubes")
public class Clube {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private float receita;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getReceita() {
        return receita;
    }

    public void setReceita(float receita) {
        this.receita = receita;
    }
}
