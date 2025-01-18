package com.marriaga.api.forohub.dto;

import com.marriaga.api.forohub.model.topico.Topico;

public record DatosRespuestaTopicoDTO(
        Long idUsuario,
        String mensaje,
        String curso,
        String titulo
) {

    public DatosRespuestaTopicoDTO(Topico topico) {
        this(topico.getUsuario().getId(), topico.getMensaje(), topico.getCurso(), topico.getTitulo());
    }
}
