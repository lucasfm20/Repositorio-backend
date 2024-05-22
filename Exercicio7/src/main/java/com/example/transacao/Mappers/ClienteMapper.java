package com.example.transacao.Mappers;

import com.example.transacao.Dtos.ClienteDto;
import com.example.transacao.models.Cliente;

public class ClienteMapper {
    public static ClienteDto toDTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        return new ClienteDto(cliente.getNome(), cliente.getSaldo());
    }

    public static Cliente toEntity(ClienteDto clienteDTO) {
        if (clienteDTO == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setSaldo(clienteDTO.getSaldo());
        return cliente;
    }
}
