package com.informatorio.ejemplo.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class EmpleadoJornada extends Empleado {

    private BigDecimal precioHora;

    public BigDecimal getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(BigDecimal precioHora) {
        this.precioHora = precioHora;
    }
}
