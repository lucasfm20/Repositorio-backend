package com.example.exe7.Mappers;

import com.example.exe7.Dtos.ClienteDto;
import com.example.exe7.Models.Cliente;

public class ClienteMapper {
    public static ClienteDto toDTO(Cliente cliente) {
        ClienteDto dto = new ClienteDto();
        dto.setNome(cliente.getNome());
        dto.setSaldo(cliente.getSaldo());
        return dto;
    }

    public static Cliente toEntity(ClienteDto dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setSaldo(dto.getSaldo());
        return cliente;
    }
}
