package com.informatorio.recetas.repository;

import com.informatorio.recetas.domain.Ingrediente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {

    // SELECT * FROM ingrediente WHERE descripcion LIKE "%descripcion%"
    List<Ingrediente> findByDescripcionLike(String descripcion);
}
