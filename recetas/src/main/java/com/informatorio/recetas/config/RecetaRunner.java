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

import java.util.List;

@Component
public class RecetaRunner implements CommandLineRunner {

    @Autowired
    private RecetaRepository recetaRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Override
    public void run(String... args) throws Exception {
        Receta receta = new Receta();
        receta.setDescription("Una buena receta");
        receta.setTiempoDeCoccion("2 horas");
        receta.setTiempoDePreparacion("Poco tiempo");

        //Receta receta = recetaRepository.findById(1L).get();

        Categoria categoria1 = new Categoria();
        categoria1.setNombre("Recetas Faciles");
        Categoria categoria2 = new Categoria();
        categoria2.setNombre("Vegetariano");

        receta.agregarCategoria(categoria1);
        receta.agregarCategoria(categoria2);

        receta = recetaRepository.save(receta);

        System.out.println("HOLA");
    }
}
