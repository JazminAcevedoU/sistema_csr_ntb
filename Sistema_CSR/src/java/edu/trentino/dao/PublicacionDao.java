/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.trentino.dao;

import edu.trentino.model.Persona;
import edu.trentino.model.Publicacion;
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
public class PublicacionDao {

    DbConnection conn;

    public PublicacionDao(DbConnection conn) {
        this.conn = conn;
    }

    public boolean insert(Publicacion publicacion) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String sql = ""
                + "insert into publicacion ("
                + "asunto,descripcion,fecha_envio,valorizacion,idSubTipoPublicacion,idUsuario) "
                + "values (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, publicacion.getAsunto());
            ps.setString(2, publicacion.getDescripcion());
            ps.setString(3, format.format(publicacion.getFecha_envio()));
            ps.setInt(4, publicacion.getValorizacion());
            //ps.setInt(5, publicacion.getEstado());
            ps.setInt(5, publicacion.getIdSubTipoPublicacion());
            ps.setInt(6, publicacion.getIdUsuario());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<Publicacion> getPublicaciones() {
        try {
            String sql = "select * from publicacion order by id desc limit 10";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Publicacion> listp = new LinkedList<>();
            List<Persona> listu = new LinkedList<>();

            Publicacion publicacion;
            Persona persona;
            //ejecutar mientras haya contenido
            while (rs.next()) {
                publicacion = new Publicacion(rs.getInt("id"));
                persona = new Persona(rs.getInt("id"));
                publicacion.setFecha_envio(rs.getDate("fecha_envio"));
                publicacion.setAsunto(rs.getString("asunto"));
                publicacion.setDescripcion(rs.getString("descripcion"));
                persona.setNombre("nombre");
                //añadir objeto a la lista
                listp.add(publicacion);
                listu.add(persona);

            }
            return listp;
        } catch (SQLException ex) {
            System.out.println("Error en VacanteDao.getultimas" + ex.getMessage());
            return null;
        }

    }

}
