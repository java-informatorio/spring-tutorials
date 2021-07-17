package com.informatorio.recetas.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String tiempoDePreparacion;
    private String tiempoDeCoccion;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Categoria> categorias = new ArrayList<>();

    @OneToMany(mappedBy = "receta",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingrediente> ingredientes;

    public Receta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    public void setTiempoDePreparacion(String tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    public String getTiempoDeCoccion() {
        return tiempoDeCoccion;
    }

    public void setTiempoDeCoccion(String tiempoDeCoccion) {
        this.tiempoDeCoccion = tiempoDeCoccion;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
        categoria.getRecetas().add(this);
    }

    @Override
    public String toString() {
        return "Receta{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", tiempoDePreparacion='" + tiempoDePreparacion + '\'' +
                ", tiempoDeCoccion='" + tiempoDeCoccion + '\'' +
                '}';
    }
}
