package com.informatorio.recetas.controller;

import com.informatorio.recetas.domain.Receta;
import com.informatorio.recetas.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecetaController {

    @Autowired
    private RecetaRepository recetaRepository;

    @RequestMapping(value = "/receta", method = RequestMethod.POST)
    public Receta createProducto(@RequestBody Receta receta) {
        return recetaRepository.save(receta);
    }

    @RequestMapping(value = "/receta/{id}", method = RequestMethod.GET)
    public Receta getRecetaPorId(@PathVariable("id") Long id) {
        return recetaRepository.findById(id).get();
    }

    @RequestMapping(value = "/receta", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(recetaRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/receta/{id}", method = RequestMethod.PUT)
    public Receta modificarProducto(@PathVariable("id") Long id, @RequestBody Receta receta) {
        Receta recetaExistente = recetaRepository.findById(id).get();
        recetaExistente.setDescription(receta.getDescription());
        return recetaRepository.save(recetaExistente);
    }

    @RequestMapping(value = "/receta/{id}", method = RequestMethod.DELETE)
    public void borrarPorId(@PathVariable("id") Long id) {
        recetaRepository.deleteById(id);
    }
}
