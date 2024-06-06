package com.example.time.services;

import com.example.time.dtos.ClubeRequestDto;
import com.example.time.dtos.ClubeResponseDto;
import com.example.time.models.Clube;
import com.example.time.repository.ClubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClubeService {

    @Autowired
    ClubeRepository clubeRepository;

    public ClubeResponseDto createClube(ClubeRequestDto requestDto) {
        Clube clube = new Clube();
        clube.setNome(requestDto.nome());
        clube.setReceita(requestDto.receita());
        Clube savedClube = clubeRepository.save(clube);
        return new ClubeResponseDto(savedClube.getId(), savedClube.getNome(), savedClube.getReceita());
    }

    public List<ClubeResponseDto> getAllClubes() {
        return clubeRepository.findAll().stream()
                .map(clube -> new ClubeResponseDto(clube.getId(), clube.getNome(), clube.getReceita()))
                .collect(Collectors.toList());
    }

    public ClubeResponseDto getClubeById(UUID id) {
        Clube clube = clubeRepository.findById(id).orElseThrow(() -> new RuntimeException("Clube not found"));
        return new ClubeResponseDto(clube.getId(), clube.getNome(), clube.getReceita());
    }

    public ClubeResponseDto updateClube(UUID id, ClubeRequestDto requestDto) {
        Clube clube = clubeRepository.findById(id).orElseThrow(() -> new RuntimeException("Clube not found"));
        clube.setNome(requestDto.nome());
        clube.setReceita(requestDto.receita());
        Clube updatedClube = clubeRepository.save(clube);
        return new ClubeResponseDto(updatedClube.getId(), updatedClube.getNome(), updatedClube.getReceita());
    }

    public void deleteClube(UUID id) {
        clubeRepository.deleteById(id);
    }

    public List<ClubeResponseDto> getClubesByNome(String nome) {
        return clubeRepository.findByNome(nome).stream()
                .map(clube -> new ClubeResponseDto(clube.getId(), clube.getNome(), clube.getReceita()))
                .collect(Collectors.toList());
    }
}
