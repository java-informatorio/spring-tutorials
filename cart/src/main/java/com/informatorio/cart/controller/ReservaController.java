package com.informatorio.cart.controller;

import com.informatorio.cart.dto.ReservaDto;
import com.informatorio.cart.service.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    @RequestMapping("/reserva")
    public ResponseEntity<?> createReserva(@Valid @RequestBody ReservaDto reservaDto) {
        return new ResponseEntity<>(reservaService.crearReserva(reservaDto), HttpStatus.CREATED);
    }
}
