package com.informatorio.ejemplo.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class EmpleadoPermanente extends Empleado {

    private String puesto;

    private BigDecimal sueldoBasico;

    private LocalDate fechaDeInicio;

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public BigDecimal getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(BigDecimal sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public LocalDate getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(LocalDate fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }
}
