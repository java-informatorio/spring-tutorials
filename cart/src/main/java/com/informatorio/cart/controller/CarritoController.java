package com.informatorio.cart.controller;

import com.informatorio.cart.domain.Carrito;
import com.informatorio.cart.domain.LineaDeCarrito;
import com.informatorio.cart.domain.Producto;
import com.informatorio.cart.domain.Usuario;
import com.informatorio.cart.dto.OperacionCarrito;
import com.informatorio.cart.repository.CarritoRepository;
import com.informatorio.cart.repository.ProductoRepository;
import com.informatorio.cart.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CarritoController {

    private final UsuarioRepository usuarioRepository;
    private final CarritoRepository carritoRepository;
    private final ProductoRepository productoRepository;

    public CarritoController(UsuarioRepository usuarioRepository, CarritoRepository carritoRepository,
                             ProductoRepository productoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.carritoRepository = carritoRepository;
        this.productoRepository = productoRepository;
    }

    @PostMapping("/usuario/{id}/carrito")
    public ResponseEntity<?> createCarrito(@PathVariable("id") Long userId,
                                           @Valid @RequestBody Carrito carrito) {
        Usuario usuario = usuarioRepository.getById(userId);
        carrito.setUsuario(usuario);
        return new ResponseEntity<>(carritoRepository.save(carrito), HttpStatus.CREATED);
    }

    @PutMapping("/usuario/{id}/carrito/{idCarrito}")
    public ResponseEntity<?> agregarProducto(@PathVariable("id") Long userId,
                                             @PathVariable("idCarrito") Long idCarrito,
                                             @Valid @RequestBody OperacionCarrito operacionCarrito) {
        Carrito carrito = carritoRepository.getById(idCarrito);
        Producto producto = productoRepository.getById(operacionCarrito.getProductoId());
        LineaDeCarrito lineaDeCarrito = new LineaDeCarrito();
        lineaDeCarrito.setCarrito(carrito);
        lineaDeCarrito.setProducto(producto);
        lineaDeCarrito.setCantidad(operacionCarrito.getCantidad());
        carrito.agregarLineDeCarrito(lineaDeCarrito);
        return new ResponseEntity<>(carritoRepository.save(carrito), HttpStatus.CREATED);
    }

    @DeleteMapping("/usuario/{id}/carrito/{idCarrito}/linea/{idLinea}}")
    public ResponseEntity<?> borrarProducto(@PathVariable("id") Long userId,
                                            @PathVariable("idCarrito") Long idCarrito,
                                            @PathVariable("idCarrito") Long idLinea) {
        //TODO - Agregar logica para remover linea
        return null;
    }
}
