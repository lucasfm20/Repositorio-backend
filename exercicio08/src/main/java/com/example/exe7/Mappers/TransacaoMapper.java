package com.example.exe7.Mappers;

import com.example.exe7.Models.Transacao;
import com.example.exe7.Dtos.TransacaoDto;

public class TransacaoMapper {
    public static TransacaoDto toDTO(Transacao transacao) {
        TransacaoDto dto = new TransacaoDto();
        dto.setRecebedor(transacao.getRecebedor());
        dto.setPagador(transacao.getPagador());
        dto.setQuantidade(transacao.getQuantidade());
        return dto;
    }

    public static Transacao toEntity(TransacaoDto dto) {
        Transacao transacao = new Transacao();
        transacao.setRecebedor(dto.getRecebedor());
        transacao.setPagador(dto.getPagador());
        transacao.setQuantidade(dto.getQuantidade());
        return transacao;
    }
}
