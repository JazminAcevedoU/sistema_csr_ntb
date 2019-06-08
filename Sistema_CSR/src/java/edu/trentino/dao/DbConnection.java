/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.trentino.dao;
import java.sql.*;

/**
 *
 * @author JAZMIN
 */
public class DbConnection {

    static String bd = "sistema_consultasdb";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/" + bd;

    Connection conn = null;

    //constructor
    public DbConnection() {
        try {
            //Obtenemos el driver para mysql
            Class.forName("com.mysql.jdbc.Driver");
            //Obtener una conexión con los parámetros específicos
            conn = DriverManager.getConnection(url, login, password);
            //si conn no es nulo, sinignifica que edimos conectar
            if (conn != null) {
                System.out.println("Connection database [" + conn + "] OK");
            }
        } catch (SQLException e) {
            //exceción ocurrida por la conexión
            System.out.println("Exception conexion: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            //exceción ocurrida por la conexión
            System.out.println("Exception driver: " + e.getMessage());
            //excepcion ocurrida por no encontrar el driver 
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void disconnect() {
        System.out.println("Closing database");
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
