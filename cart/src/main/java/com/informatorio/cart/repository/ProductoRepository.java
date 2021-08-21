package com.informatorio.cart.repository;

import com.informatorio.cart.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    //SELECT * FROM Product WHERE nombre LIKE "a%"
    @Query("SELECT p FROM Producto p WHERE p.nombre LIKE %:comienzaCon%")
    List<Producto> buscarPorNombreQueComienza(@Param("comienzaCon") String comienzaCon);
}
