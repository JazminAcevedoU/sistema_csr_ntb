/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.trentino.dao;

import edu.trentino.model.TipoPublicacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author JAZMIN
 */
public class TipoPublicacionDao {
    DbConnection conn;

    public TipoPublicacionDao(DbConnection conn) {
        this.conn = conn;
    }
    
    
    //insert
    
    
    
    //lectura
    public List<TipoPublicacion> getTipoPublicacion(){
        try {
            String sql = "SELECT * FROM subtipopublicacion ORDER BY nombre_subtipo DESC";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<TipoPublicacion> list = new LinkedList<>();
            TipoPublicacion tipoPublicacion;
            //ejecutar mientras haya contenido
            while (rs.next()) {
                tipoPublicacion = new TipoPublicacion(rs.getInt("idSubTipoPublicacion"));
                tipoPublicacion.setNombre_subtipo(rs.getString("nombre_subtipo"));
                //añadir objeto a la lista
                list.add(tipoPublicacion); 
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Error en TipoPersonaDao.getTipoPersona" + ex.getMessage());
            return null;
        }
        
    }
}
