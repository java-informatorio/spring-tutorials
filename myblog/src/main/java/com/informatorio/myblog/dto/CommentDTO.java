package com.informatorio.myblog.dto;

public class CommentDTO {

  private Long idAutor;
  private String comentario;

  public Long getIdAutor() {
    return idAutor;
  }

  public void setIdAutor(Long idAutor) {
    this.idAutor = idAutor;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }
}
