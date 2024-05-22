package com.example.transacao.controllers;

import com.example.transacao.Dtos.ClienteDto;
import com.example.transacao.models.Cliente;
import com.example.transacao.models.Transacao;
import com.example.transacao.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TransacaoController {
    private ArrayList<Transacao> listaTransacao = new ArrayList<>();
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente")
    public ResponseEntity<ClienteDto> getCliente(@RequestParam String nome)
    {
        Cliente cliente = clienteService.findByNome(nome);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        ClienteDto clienteDTO = clienteService.getClienteDto(cliente);
        return ResponseEntity.ok(clienteDTO);
    }


    @PostMapping("/transacao")
    public ArrayList<Transacao> postTransacao(@RequestBody Transacao trans)
    {
        Transacao transacao = new Transacao(
                trans.getRecebedor(),
                trans.getPagador(),
                trans.getQuantidade()
        );

        listaTransacao.add(transacao);
        return listaTransacao;
    }


}
