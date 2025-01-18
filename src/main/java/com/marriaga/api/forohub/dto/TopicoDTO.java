package com.marriaga.api.forohub.dto;

import com.marriaga.api.forohub.model.topico.Topico;

import java.time.LocalDateTime;

public record TopicoDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha
) {
    public TopicoDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha());
    }
}
