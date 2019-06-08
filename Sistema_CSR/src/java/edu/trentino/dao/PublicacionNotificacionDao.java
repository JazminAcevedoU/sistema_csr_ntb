package edu.trentino.dao;

import edu.trentino.model.PublicacionNotificacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PublicacionNotificacionDao {

    DbConnection conn;

    public PublicacionNotificacionDao(DbConnection conn) {
        this.conn = conn;
    }

    public List<PublicacionNotificacion> getPublicacion() {
        try {
            String sql = "SELECT pb.idPublicacion, pb.asunto, pb.descripcion, pb.fecha_envio, ps.nombre, ps.apellido FROM publicacion pb"
                    + " INNER JOIN usuario u ON pb.idUsuario = u.idUsuario"
                    + " INNER JOIN persona ps ON u.idPersona = ps.idPersona"
                    + " ORDER BY pb.idPublicacion DESC";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<PublicacionNotificacion> list = new LinkedList<>();
            PublicacionNotificacion publicacionNotificacion;
            while (rs.next()) {
                publicacionNotificacion = new PublicacionNotificacion();
                publicacionNotificacion.setId(rs.getInt("idPublicacion"));
                publicacionNotificacion.setAsunto(rs.getString("asunto"));
                publicacionNotificacion.setDescripcion(rs.getString("descripcion"));
                publicacionNotificacion.setFecha_envio(rs.getDate("fecha_envio"));
                publicacionNotificacion.setNombre(rs.getString("nombre"));
                publicacionNotificacion.setApellido(rs.getString("apellido"));

                //añadir objeto a la lista
                list.add(publicacionNotificacion);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Error en PublicacionNotificacionDao.getPublicacion" + ex.getMessage());
            return null;
        }

    }
}
