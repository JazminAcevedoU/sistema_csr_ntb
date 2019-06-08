
package edu.trentino.model;

public class Comentario {
    
    private int id;
    private String detalle_comentario;
    private int estado;
    private int id_publicacion;
    private int id_usuario;

    public Comentario(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetalle_comentario() {
        return detalle_comentario;
    }

    public void setDetalle_comentario(String detalle_comentario) {
        this.detalle_comentario = detalle_comentario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId_publicacion() {
        return id_publicacion;
    }

    public void setId_publicacion(int id_publicacion) {
        this.id_publicacion = id_publicacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}
