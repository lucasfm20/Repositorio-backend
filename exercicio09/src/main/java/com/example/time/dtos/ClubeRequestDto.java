package com.example.time.dtos;

import java.util.UUID;

public record ClubeRequestDto(
        UUID id,
        String nome,
        float receita) {
}
