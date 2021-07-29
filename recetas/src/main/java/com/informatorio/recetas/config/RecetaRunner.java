package com.informatorio.recetas.config;

import com.informatorio.recetas.domain.Categoria;
import com.informatorio.recetas.domain.Ingrediente;
import com.informatorio.recetas.domain.Receta;
import com.informatorio.recetas.domain.UnidadDeMedida;
import com.informatorio.recetas.repository.IngredienteRepository;
import com.informatorio.recetas.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RecetaRunner implements CommandLineRunner {

    @Autowired
    private RecetaRepository recetaRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Override
    public void run(String... args) throws Exception {
/*
        Receta unaReceta = recetaRepository.findById(1L)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro receta"));
        //hacer algo

        if (unaReceta != null) {
            //hacer algo
        } else {
            throw new EntityNotFoundException("No se encontro receta");
        }

        List<Receta> recetas = recetaRepository.findByDescription("Pizza Napolitana");

        List<String> nombresRecetas = recetas.stream()
                .filter(receta1 -> !receta1.getDescription().isEmpty())
                .map(receta1 -> receta1.getDescription())
                .collect(Collectors.toList());

        List<String> resultados = new ArrayList<>();
        for (Receta receta2 : recetas) {
            if (!receta2.getDescription().isEmpty()) {
                resultados.add(receta2.getDescription());
            }
        }

        List<Receta> masRecetas = recetaRepository
                .findByFechaCreacionBetween(
                        LocalDate.of(2020, 12,1),
                        LocalDate.of(2020,12,31));

        Iterable<Receta> todasLasRecetas = recetaRepository.findAll();


        System.out.println("HOLA");*/
    }
}
