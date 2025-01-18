package com.marriaga.api.forohub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopicoDTO(
        @NotNull
        Long idUsuario,
        @NotBlank
        String titulo,
        @NotBlank
        String curso,
        @NotBlank
        String mensaje

) {
}
