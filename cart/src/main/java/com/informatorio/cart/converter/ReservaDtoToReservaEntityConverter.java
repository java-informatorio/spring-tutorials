package com.informatorio.cart.converter;

import com.informatorio.cart.domain.Reserva;
import com.informatorio.cart.dto.ReservaDto;
import com.informatorio.cart.repository.ProductoRepository;
import com.informatorio.cart.repository.UsuarioRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReservaDtoToReservaEntityConverter implements Converter<ReservaDto, Reserva> {

    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;

    public ReservaDtoToReservaEntityConverter(ProductoRepository productoRepository,
                                              UsuarioRepository usuarioRepository) {
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Reserva convert(ReservaDto reservaDto) {
        Reserva reserva = new Reserva();
        reserva.setProductoId(reservaDto.getProductoId());
        reserva.setNombreProduct(productoRepository.getById(reservaDto.getProductoId()).getNombre());
        reserva.setUsername(usuarioRepository.getById(reservaDto.getUsuarioId()).getNombreDeUsuario());
        reserva.setEstaActivo(true); //puede ir una logica si tiene carritos es true, sino false
        return reserva;
    }
}
