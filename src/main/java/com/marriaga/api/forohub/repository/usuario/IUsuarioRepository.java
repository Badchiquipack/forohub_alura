package com.marriaga.api.forohub.repository.usuario;

import com.marriaga.api.forohub.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String username);
}
