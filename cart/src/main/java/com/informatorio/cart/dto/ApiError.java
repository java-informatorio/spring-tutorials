package com.informatorio.cart.dto;

import org.springframework.http.HttpStatus;

public class ApiError {

    private HttpStatus status;
    private String mensaje;
    private int cantidadDeErrores;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCantidadDeErrores() {
        return cantidadDeErrores;
    }

    public void setCantidadDeErrores(int cantidadDeErrores) {
        this.cantidadDeErrores = cantidadDeErrores;
    }
}
