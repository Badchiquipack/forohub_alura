package com.marriaga.api.forohub.model.topico;

import com.marriaga.api.forohub.dto.DatosActualizarTopicoDTO;
import com.marriaga.api.forohub.model.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String titulo;
    private String mensaje;
    private String curso;
    private LocalDateTime fecha;

    public Topico() {
    }

    public Topico(Long id, Usuario usuario, String titulo, String mensaje, String curso, LocalDateTime fecha) {
        this.id = id;
        this.usuario = usuario;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.curso = curso;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void actualizarDatos(DatosActualizarTopicoDTO datosActualizarTopicoDTO) {
        if (datosActualizarTopicoDTO.curso() != null) {
            this.curso = datosActualizarTopicoDTO.curso();
        }
        if (datosActualizarTopicoDTO.mensaje() != null) {
            this.mensaje = datosActualizarTopicoDTO.mensaje();
        }
        if (datosActualizarTopicoDTO.titulo() != null) {
            this.titulo = datosActualizarTopicoDTO.titulo();
        }
    }
}
