package com.marriaga.api.forohub.controller;

import com.marriaga.api.forohub.dto.DatosActualizarTopicoDTO;
import com.marriaga.api.forohub.dto.DatosRegistroTopicoDTO;
import com.marriaga.api.forohub.dto.DatosRespuestaTopicoDTO;
import com.marriaga.api.forohub.dto.TopicoDTO;
import com.marriaga.api.forohub.repository.topico.ITopicoRepository;
import com.marriaga.api.forohub.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private ITopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopicoDTO datosRegistroTopico) {
        var detalleRegistro = topicoService.registrar(datosRegistroTopico);
        return ResponseEntity.ok(detalleRegistro);
    }

    @GetMapping
    public ResponseEntity<Page<TopicoDTO>> listarTopicos(@PageableDefault(size = 5) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(TopicoDTO::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopicoDTO datosActualizarTopicoDTO) {

        return ResponseEntity.ok(topicoService.actualizarTopico(datosActualizarTopicoDTO));
    }

    @DeleteMapping("{id}")
    @Transactional
    public  ResponseEntity eliminarTopico(@PathVariable Long id){
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}
