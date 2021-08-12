package com.informatorio.cart.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javassist.bytecode.LineNumberAttribute;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @NotBlank
    private String device;

    @Transient
    private String nombreDeUsuario;

    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    @UpdateTimestamp
    private LocalDateTime fechaUltimaModificacion;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaDeCarrito> lineasDeCarrito = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getNombreDeUsuario() {
        return usuario.getNombreDeUsuario();
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public List<LineaDeCarrito> getLineasDeCarrito() {
        return lineasDeCarrito;
    }

    public void agregarLineDeCarrito(LineaDeCarrito lineaDeCarrito) {
        lineasDeCarrito.add(lineaDeCarrito);
        lineaDeCarrito.setCarrito(this);
    }

    public void removerLineDeCarrito(LineaDeCarrito lineaDeCarrito) {
        lineasDeCarrito.remove(lineaDeCarrito);
        lineaDeCarrito.setCarrito(null);
    }
}
