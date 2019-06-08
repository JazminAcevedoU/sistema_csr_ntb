package edu.trentino.dao;

import edu.trentino.model.Persona;
import java.sql.PreparedStatement;

public class PersonaDao {

    DbConnection conn;

    public PersonaDao(DbConnection conn) {
        this.conn = conn;
    }

    public boolean insert(Persona persona) {

        String sql = "insert into persona (nombre, apellido, dni, telefono, idTipo_Persona) values (?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getDni());
            ps.setString(4, persona.getTelefono());
            ps.setInt(5, persona.getId_tipo_persona());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
