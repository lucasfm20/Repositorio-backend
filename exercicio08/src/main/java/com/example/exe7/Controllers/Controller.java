package com.example.exe7.Controllers;

import com.example.exe7.Dtos.ClienteDto;
import com.example.exe7.Dtos.TransacaoDto;
import com.example.exe7.Mappers.ClienteMapper;
import com.example.exe7.Mappers.TransacaoMapper;
import com.example.exe7.Models.Cliente;
import com.example.exe7.Models.Transacao;
import com.example.exe7.Repositorios.ClienteRepositorio;
import com.example.exe7.Repositorios.TransacaoRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private ClienteRepositorio clienteRepository;

    @Autowired
    private TransacaoRepositorio transacaoRepository;

    @GetMapping("/cliente/{nome}")
    public ResponseEntity<ClienteDto> getClienteByNome(@PathVariable String nome) {
        Cliente cliente = clienteRepository.findByNome(nome);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        ClienteDto clienteDTO = ClienteMapper.toDTO(cliente);
        return ResponseEntity.ok(clienteDTO);
    }



    @PostMapping("/transacao")
    public ResponseEntity<TransacaoDto> createTransacao(@Valid @RequestBody TransacaoDto transacaoDTO) {
        Cliente pagador = clienteRepository.findByNome(transacaoDTO.getPagador());
        Cliente recebedor = clienteRepository.findByNome(transacaoDTO.getRecebedor());

        if (pagador == null || recebedor == null) {
            return ResponseEntity.badRequest().build();
        }

        if (pagador.getSaldo() < transacaoDTO.getQuantidade()) {
            return ResponseEntity.badRequest().build();
        }

        pagador.setSaldo(pagador.getSaldo() - transacaoDTO.getQuantidade());
        recebedor.setSaldo(recebedor.getSaldo() + transacaoDTO.getQuantidade());

        clienteRepository.save(pagador);
        clienteRepository.save(recebedor);

        Transacao transacao = TransacaoMapper.toEntity(transacaoDTO);
        transacaoRepository.save(transacao);

        return ResponseEntity.ok(transacaoDTO);
    }
}
