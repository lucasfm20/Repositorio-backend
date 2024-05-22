package com.example.transacao.services;

import com.example.transacao.ClienteRepositorio;
import com.example.transacao.Dtos.ClienteDto;
import com.example.transacao.Mappers.ClienteMapper;
import com.example.transacao.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClienteService {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public ClienteDto getClienteDto(Cliente cliente) {
        return ClienteMapper.toDTO(cliente);
    }

    public Cliente createClienteFromDto(ClienteDto clienteDto, String senha) {
        Cliente cliente = ClienteMapper.toEntity(clienteDto);
        cliente.setSenha(senha);
        return cliente;
    }

    public Cliente findByNome(String nome) {
        Optional<Cliente> cliente = clienteRepositorio.findByNome(nome);
        return cliente.orElse(null);
    }
}
