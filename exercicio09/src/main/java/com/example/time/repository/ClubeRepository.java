package com.example.time.repository;

import com.example.time.models.Clube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, UUID> {
    List<Clube> findByNome(String nome);
}
