package com.informatorio.cart.converter;

import com.informatorio.cart.domain.Producto;
import com.informatorio.cart.domain.Reserva;
import com.informatorio.cart.domain.Usuario;
import com.informatorio.cart.dto.ReservaDto;
import com.informatorio.cart.repository.ProductoRepository;
import com.informatorio.cart.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ReservaDtoToReservaEntityConverterTest {

    @Mock
    private ProductoRepository productoRepository;
    @Mock
    private UsuarioRepository usuarioRepository;
    @InjectMocks
    private ReservaDtoToReservaEntityConverter converter;

    @Test
    void test1() {
        Producto producto = new Producto();
        producto.setNombre("Remera Talle L");

        Usuario usuario = new Usuario();
        usuario.setNombreDeUsuario("bart.simpson@gmail.com");

        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setUsuarioId(1L);
        reservaDto.setProductoId(1L);
        reservaDto.setObservacion("Esto es una observacion");

        given(productoRepository.getById(reservaDto.getProductoId())).willReturn(producto);
        given(usuarioRepository.getById(reservaDto.getUsuarioId())).willReturn(usuario);

        Reserva reserva = converter.convert(reservaDto);

        assertThat(reserva).isNotNull();
        assertThat(reserva.getUsername()).isEqualTo("bart.simpson@gmail.com");
        assertThat(reserva.getNombreProduct()).isEqualTo("Remera Talle L");
    }
}