package org.example;

public class Filme implements Indicavel {
    private String nome;
    private String genero;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Filme(String nome, String genero, Indicavel indicavel) {
        this.nome = nome;
        this.genero = genero;

    }
}
