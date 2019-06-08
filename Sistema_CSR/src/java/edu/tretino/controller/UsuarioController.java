/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tretino.controller;

import edu.trentino.dao.DbConnection;
import edu.trentino.dao.PerfilUsuarioDao;
import edu.trentino.dao.UsuarioDao;
import edu.trentino.model.PerfilUsuario;
import edu.trentino.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JAZMIN
 */
public class UsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        DbConnection conn = new DbConnection();
        PerfilUsuarioDao perfilUsuarioDao = new PerfilUsuarioDao(conn);

        //traer las ultimas
        List<PerfilUsuario> listaPerfilUsuario = perfilUsuarioDao.getPerfilUsuario();
        conn.disconnect();
        request.setAttribute("perfilUsuario", listaPerfilUsuario);

        rd = request.getRequestDispatcher("/frmPersona.jsp");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String correoParam = request.getParameter("correo");
        String contraseniaParam = request.getParameter("contrasenia");
        int perfilUsuarioParam = Integer.parseInt(request.getParameter("perfilusuario"));
        
        int idPersonaParam  = Integer.parseInt(request.getParameter("idpersona"));

        Usuario usuario = new Usuario();

        usuario.setCorreo(correoParam);
        usuario.setContrasenia(contraseniaParam);
        usuario.setId_perfil(perfilUsuarioParam);
        
        //usuario.setId_persona(idPersonaParam);
        

        System.out.println(usuario);

        // Procesamos los datos guardar en bd
        DbConnection conn = new DbConnection();

        UsuarioDao usuarioDao = new UsuarioDao(conn);
        //boolean status = usuarioDao.insert(usuario);

        //Preparamos un mensaje para el Usuario
        String msg = "";
        if (true) {
            msg = "El usuario fue guardado correctamente";
        } else {
            msg = "Ocurrió un error. El usuario no fue guardado";
        }

        conn.disconnect();
        RequestDispatcher rd;

        //Compartimos la variable msg para poder
// acceder desde la vista ocon expression language        
        request.setAttribute("message", msg);
        //enviamos respuesta renderizamos la vista mensaje.jsp
        rd = request.getRequestDispatcher("/mensaje.jsp");
        rd.forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
