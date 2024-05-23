package com.example.exe7.Repositorios;

import com.example.exe7.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    Cliente findByNome(String nome);
}
