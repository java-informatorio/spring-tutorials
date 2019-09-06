package com.informatorio.mvcapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@Entity
public class Arbol {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotBlank(message = "El nombre no debe ser nulo")
  private String nombre;

  @Transient
  private String familiaString;

  @OneToOne
  private Familia familia;

  private String descripcion;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getFamiliaString() {
    return familiaString;
  }

  public void setFamiliaString(String familiaString) {
    this.familiaString = familiaString;
  }

  public Familia getFamilia() {
    return familia;
  }

  public void setFamilia(Familia familia) {
    this.familia = familia;
  }
}
