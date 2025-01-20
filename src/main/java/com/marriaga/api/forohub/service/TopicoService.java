package com.marriaga.api.forohub.service;

import com.marriaga.api.forohub.dto.DatosActualizarTopicoDTO;
import com.marriaga.api.forohub.dto.DatosRegistroTopicoDTO;
import com.marriaga.api.forohub.dto.DatosRespuestaTopicoDTO;
import com.marriaga.api.forohub.infra.excepciones.ValidacionException;
import com.marriaga.api.forohub.model.topico.Topico;
import com.marriaga.api.forohub.repository.topico.ITopicoRepository;
import com.marriaga.api.forohub.repository.usuario.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TopicoService {

    @Autowired
    private ITopicoRepository topicoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public DatosRespuestaTopicoDTO registrar(DatosRegistroTopicoDTO datosRegistroTopico) {

        if (!usuarioRepository.existsById(datosRegistroTopico.idUsuario())) {
            throw new ValidacionException("No existe un usuario con el id proporcionado");
        }

        var usuario = usuarioRepository.findById(datosRegistroTopico.idUsuario());
        var fecha = LocalDateTime.now();

        Topico topico = new Topico(null, usuario.get(), datosRegistroTopico.titulo(), datosRegistroTopico.mensaje(),
                datosRegistroTopico.curso(), fecha);
        topicoRepository.save(topico);
        return new DatosRespuestaTopicoDTO(topico);
    }

    @Transactional
    public DatosRespuestaTopicoDTO actualizarTopico(DatosActualizarTopicoDTO datosActualizarTopicoDTO) {
        if (!topicoRepository.existsById(datosActualizarTopicoDTO.id())) {
            throw new ValidacionException("No existe un usuario con el id proporcionado");
        }
        var topico = topicoRepository.getReferenceById(datosActualizarTopicoDTO.id());
        topico.actualizarDatos(datosActualizarTopicoDTO);
        return new DatosRespuestaTopicoDTO(topico.getUsuario().getId(), topico.getMensaje(),
                topico.getCurso(), topico.getTitulo());
    }

    public void eliminarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new ValidacionException("No existe un topico con el id proporcionado");
        }
        topicoRepository.delete(topicoRepository.getReferenceById(id));
    }

    public DatosRespuestaTopicoDTO obtenerPorId(Long id) {
        if (!topicoRepository.existsById(id)){
            throw new ValidacionException("El topico con el id proporcionado no existe");
        }
        var topico = topicoRepository.findById(id);

    return new DatosRespuestaTopicoDTO(topico.get());
    }
}
