package com.informatorio.recetas.repository;

import com.informatorio.recetas.domain.Receta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends CrudRepository<Receta, Long> {
}
