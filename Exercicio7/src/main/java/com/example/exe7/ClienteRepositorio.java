package com.example.exe7;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    Cliente findByNome(String nome);
}
