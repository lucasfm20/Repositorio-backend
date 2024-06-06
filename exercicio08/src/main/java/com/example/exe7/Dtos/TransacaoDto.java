package com.example.exe7.Dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TransacaoDto {
    @NotEmpty(message = "O campo 'recebedor' não pode estar vazio.")
    private String recebedor;

    @NotEmpty(message = "O campo 'pagador' não pode estar vazio.")
    private String pagador;

    @NotNull(message = "O campo 'quantidade' não pode ser nulo.")
    @Positive(message = "A quantidade deve ser maior que zero.")
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
