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

public class Persona {

    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private Usuario usuario;
    private int estado = 1;
    //id_tipo_persona
    private int id_tipo_persona;

    //constructor
    public Persona(int id) {
        this.id = id;

    }

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }   

    public int getId_tipo_persona() {
        return id_tipo_persona;
    }

    public void setId_tipo_persona(int id_tipo_persona) {
        this.id_tipo_persona = id_tipo_persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
