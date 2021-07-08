package com.informatorio.ejemplo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String saludar() {
        return "HOLA INFORMATORIO";
    }
}
