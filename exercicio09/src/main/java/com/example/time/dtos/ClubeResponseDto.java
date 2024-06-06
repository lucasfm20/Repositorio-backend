package com.example.time.dtos;

import java.util.UUID;

public record ClubeResponseDto(
        UUID id,
        String nome,
        float receita) {
}
