package com.marriaga.api.forohub.repository.topico;

import com.marriaga.api.forohub.model.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITopicoRepository extends JpaRepository<Topico, Long> {
}
