package com.informatorio.ejemplo.config;

import com.informatorio.ejemplo.entity.Empleado;
import com.informatorio.ejemplo.entity.EmpleadoJornada;
import com.informatorio.ejemplo.entity.EmpleadoPermanente;
import com.informatorio.ejemplo.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class EmpleadoRunner implements CommandLineRunner {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public void run(String... args) throws Exception {
        EmpleadoJornada empleadoJornada = new EmpleadoJornada();
        empleadoJornada.setApellido("Homero");
        empleadoJornada.setNombre("Simpson");
        empleadoJornada.setFechaDeNacimiento(LocalDate.now().minusYears(40));
        empleadoJornada.setPrecioHora(new BigDecimal(1000));

        empleadoRepository.save(empleadoJornada);
    }
}
