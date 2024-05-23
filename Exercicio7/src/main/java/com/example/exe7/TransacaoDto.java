package com.example.exe7;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TransacaoDto {
    @NotEmpty
    private String recebedor;

    @NotEmpty
    private String pagador;

    @NotNull
    @Positive
    private Double quantidade;

    public String getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(String recebedor) {
        this.recebedor = recebedor;
    }

    public String getPagador() {
        return pagador;
    }

    public void setPagador(String pagador) {
        this.pagador = pagador;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
