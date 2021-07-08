package com.informatorio.ejemplo.controller;

import com.informatorio.ejemplo.entity.Empleado;
import com.informatorio.ejemplo.repository.EmpleadoRepository;
import com.informatorio.ejemplo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoController {

    private EmpleadoRepository repository;
    private HelloService helloService;

    @Autowired
    public EmpleadoController(EmpleadoRepository repository, HelloService helloService) {
        this.repository = repository;
        this.helloService = helloService;
    }

    @GetMapping(value = "/saludar")
    public @ResponseBody String saludar() {
        return helloService.saludar();
    }

}
