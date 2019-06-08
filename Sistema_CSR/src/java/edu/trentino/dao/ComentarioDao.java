
package edu.trentino.dao;

import edu.trentino.model.Comentario;
import java.sql.PreparedStatement;


public class ComentarioDao {
    
    DbConnection conn;

    public ComentarioDao(DbConnection conn) {
        this.conn = conn;
    }
    
    public boolean insert(Comentario comentario) {

        String sql = "insert into comentarios (detalle_comentario, idPublicacion, idUsuario) values (?,?,?)";

        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, comentario.getDetalle_comentario());
            ps.setInt(2, comentario.getId_publicacion());
            ps.setInt(3, comentario.getId_usuario());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
