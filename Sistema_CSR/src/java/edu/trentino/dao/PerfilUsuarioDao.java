/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.trentino.dao;

import edu.trentino.model.PerfilUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author JAZMIN
 */
public class PerfilUsuarioDao {
    DbConnection conn;

    public PerfilUsuarioDao(DbConnection conn) {
        this.conn = conn;
    }
    
    public boolean insert(PerfilUsuario perfilUsuario){
        String sql = "insert into perfil values (?,?)";
        
        
        try {PreparedStatement ps = conn.getConnection().prepareStatement(sql);
        ps.setInt(1, perfilUsuario.getId());
        ps.setString(2, perfilUsuario.getNombre_perfil());
       
        ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }     
    }
    
    public List<PerfilUsuario> getPerfilUsuario(){
        try {
            String sql = "SELECT * FROM perfil ORDER BY nombre_perfil";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<PerfilUsuario> list = new LinkedList<>();
            PerfilUsuario perfilUsuario;
            //ejecutar mientras haya contenido
            while (rs.next()) {
                perfilUsuario = new PerfilUsuario(rs.getInt("idPerfil"));
                perfilUsuario.setNombre_perfil(rs.getString("nombre_perfil"));
                //añadir objeto a la lista
                list.add(perfilUsuario); 
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Error en TipoPersonaDao.getTipoPersona" + ex.getMessage());
            return null;
        }
        
    }
}
