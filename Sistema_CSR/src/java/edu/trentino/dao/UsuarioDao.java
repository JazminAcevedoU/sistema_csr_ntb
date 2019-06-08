/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.trentino.dao;

import edu.trentino.model.Persona;
import edu.trentino.model.Usuario;
import java.sql.PreparedStatement;

/**
 *
 * @author JAZMIN
 */
public class UsuarioDao {
    DbConnection conn;

    public UsuarioDao(DbConnection conn) {
        this.conn = conn;
    }
    
    public boolean insert(Persona persona){
        
        String sql = ""
                + "INSERT INTO usuario (correo, contrasenia, estado, idPerfil, idPersona) "
                + "values (?,?,?,?, (SELECT idPersona FROM persona WHERE nombre = ? AND apellido = ?))";
        
        
        try {PreparedStatement ps = conn.getConnection().prepareStatement(sql);
        ps.setString(1, persona.getUsuario().getCorreo());
        ps.setString(2, persona.getUsuario().getContrasenia());
        ps.setInt(3, persona.getUsuario().getEstado());
        ps.setInt(4, persona.getUsuario().getId_perfil());
        ps.setString(5, persona.getNombre());
        ps.setString(6, persona.getApellido());

        ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }     
        
    }
    
    public boolean Login(){
        
        return true;
    }
}
