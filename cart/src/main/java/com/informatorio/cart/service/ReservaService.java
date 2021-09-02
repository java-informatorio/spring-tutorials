package com.informatorio.cart.service;

import com.informatorio.cart.domain.Reserva;
import com.informatorio.cart.dto.ReservaDto;
import com.informatorio.cart.repository.ReservaRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private final Converter<ReservaDto, Reserva> reservaDtoToReservaConverter;
    private final ReservaRepository reservaRepository;

    public ReservaService(Converter<ReservaDto, Reserva> reservaDtoToReservaConverter,
                          ReservaRepository reservaRepository) {
        this.reservaDtoToReservaConverter = reservaDtoToReservaConverter;
        this.reservaRepository = reservaRepository;
    }

    public boolean crearReserva(ReservaDto reservaDto) {
        Reserva reserva = reservaDtoToReservaConverter.convert(reservaDto);
        reservaRepository.save(reserva);
        return true;
    }
}
