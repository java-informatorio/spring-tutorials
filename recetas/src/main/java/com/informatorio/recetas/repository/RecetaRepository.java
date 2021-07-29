package com.informatorio.recetas.repository;

import com.informatorio.recetas.domain.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {

    List<Receta> findByDescription(String descripcion);

    List<Receta> findByFechaCreacionBetween(LocalDate desde, LocalDate hasta);
}
