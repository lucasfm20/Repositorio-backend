package org.example;

public class Indicacao {
     Indicavel indicavel;
    private String categoria;


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public Indicacao(String categoria,Indicavel indicavel){
        this.categoria = categoria;
        this.indicavel = indicavel;
    }
}
