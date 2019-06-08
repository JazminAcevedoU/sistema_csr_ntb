/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.trentino.model;

/**
 *
 * @author JAZMIN
 */
public class TipoPublicacion {
    private int id;
    private String nombre_subtipo;

    public TipoPublicacion(int id) {
        this.id = id;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_subtipo() {
        return nombre_subtipo;
    }

    public void setNombre_subtipo(String nombre_subtipo) {
        this.nombre_subtipo = nombre_subtipo;
    }
    
    
}
