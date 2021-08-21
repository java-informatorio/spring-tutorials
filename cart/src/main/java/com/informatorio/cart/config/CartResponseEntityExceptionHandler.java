package com.informatorio.cart.config;

import com.informatorio.cart.dto.ApiError;
import com.informatorio.cart.exception.CarritoException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class CartResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                          HttpStatus status, WebRequest request) {
        ApiError error = new ApiError();
        error.setStatus(status);
        error.setMensaje(ex.getMessage());
        error.setCantidadDeErrores(ex.getErrorCount());
        return new ResponseEntity<Object>(error, HttpStatus.I_AM_A_TEAPOT);
    }
}
