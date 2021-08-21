package com.informatorio.cart.repository;

import com.informatorio.cart.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByFechaDeCreacionAfter(LocalDateTime dateTime);

    List<Usuario> findByFechaDeCreacionBetween(LocalDateTime desde, LocalDateTime hasta);

    List<Usuario> findByNombreContainingAndApellidoContainingAndDireccionContaining(String nombre, String apellido, String direccion);
}
