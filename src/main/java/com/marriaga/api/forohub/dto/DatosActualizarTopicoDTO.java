package com.marriaga.api.forohub.dto;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopicoDTO(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        String curso
) {
}
