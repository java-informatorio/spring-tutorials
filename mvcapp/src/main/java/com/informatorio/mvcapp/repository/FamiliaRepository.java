package com.informatorio.mvcapp.repository;

import com.informatorio.mvcapp.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {

  //SELECT * FROM FAMILIA WHERE nombre=${nombre}
  Familia findFamiliaByNombre(String nombre);
}
