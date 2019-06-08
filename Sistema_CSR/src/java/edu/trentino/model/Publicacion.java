/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.trentino.model;

import java.util.Date;

/**
 *
 * @author JAZMIN
 */
public class Publicacion {

    private int id;
    private String asunto;
    private String descripcion;
    private Date fecha_envio;
    private int valorizacion;
    private int estado;
    private int idSubTipoPublicacion;
    private int idUsuario;

    public Publicacion(int id) {
        this.id = id;
        this.fecha_envio = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public int getValorizacion() {
        return valorizacion;
    }

    public void setValorizacion(int valorizacion) {
        this.valorizacion = valorizacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdSubTipoPublicacion() {
        return idSubTipoPublicacion;
    }

    public void setIdSubTipoPublicacion(int idSubTipoPublicacion) {
        this.idSubTipoPublicacion = idSubTipoPublicacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
