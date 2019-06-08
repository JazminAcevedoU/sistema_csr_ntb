/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.trentino.dao;

import edu.trentino.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JAZMIN
 */
public class LoginDao {
    
    
    private DbConnection conn;
    
    //todas las clases deben de tener un constructor
    public LoginDao(DbConnection conn){
        this.conn=conn;
                       
    }
    public Usuario validar_usuario(Usuario usuarior){
        Usuario usuario=null;
        String sql ="Select * from  usuario where correo=? and contrasenia=?";
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, usuarior.getCorreo());
            ps.setString(2, usuarior.getContrasenia());
            ResultSet rs = ps.executeQuery();
            
        
            while (rs.next()){
                usuario = new Usuario();
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setEstado(rs.getInt("estado"));
            }
            return usuario;
        } catch (SQLException ex) {
            System.out.println("Error VacanteDao.getbyId"+ ex.getMessage());
            return null;
        }

    }
}
