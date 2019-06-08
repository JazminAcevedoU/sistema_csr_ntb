/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.trentino.dao;

import edu.trentino.model.TipoPersona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author JAZMIN
 */
public class TipoPersonaDao {
    DbConnection conn;

    public TipoPersonaDao(DbConnection conn) {
        this.conn = conn;
    }
    
    //                     tipo   objeto
    public boolean insert(TipoPersona tipoPersona){
       
        String sql = "insert into Tipo_Persona values (?,?)";
        
        
        try {PreparedStatement ps = conn.getConnection().prepareStatement(sql);
        ps.setInt(1, tipoPersona.getId());
        ps.setString(2, tipoPersona.getTipo_persona());
       
        ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }     
    }
    
    public List<TipoPersona> getTipoPersona(){
        try {
            String sql = "SELECT * FROM tipo_persona ORDER BY nombre_Tipo_Persona DESC";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<TipoPersona> list = new LinkedList<>();
            TipoPersona tipoPersona;
            //ejecutar mientras haya contenido
            while (rs.next()) {
                tipoPersona = new TipoPersona(rs.getInt("idTipo_Persona"));
                tipoPersona.setTipo_persona(rs.getString("nombre_Tipo_Persona"));
                //añadir objeto a la lista
                list.add(tipoPersona); 
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Error en TipoPersonaDao.getTipoPersona" + ex.getMessage());
            return null;
        }
        
    }
}
