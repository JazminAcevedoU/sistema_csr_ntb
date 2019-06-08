/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tretino.controller;

import edu.trentino.dao.DbConnection;
import edu.trentino.dao.LoginDao;
import edu.trentino.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JAZMIN
 */
public class LoginController extends HttpServlet {
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

        String usuarioParam = request.getParameter("correo");
        String usuarioMayus = usuarioParam.toUpperCase();
        String passwordParam = request.getParameter("contrasenia");

        Usuario usuario = new Usuario();

        usuario.setCorreo(usuarioMayus);
        usuario.setContrasenia(passwordParam);

        DbConnection conn = new DbConnection();
        LoginDao loginDao = new LoginDao(conn);
        ///Recoger el usuario de la funcion validada.
        Usuario usuarioL = loginDao.validar_usuario(usuario);

        RequestDispatcher rd;
        //Preparando un mensaje para el usuario
        String msg = "";
        if (usuarioL != null) {
            System.out.println("existe el usuario.");
            int idUsuarioLogeado = usuarioL.getId();
            
            System.out.println("Usuario: " + idUsuarioLogeado);
            HttpSession session=request.getSession();  
            session.setAttribute("user",usuarioL.getId());              
            msg = "los datos con correctos";
            rd = request.getRequestDispatcher("/index.jsp");
        } else {
            System.out.println("No existe el usuario.");
            msg = "Datos invalidos";
            rd = request.getRequestDispatcher("/frmLogin.jsp");
        }
        
        
        /*request.getSession().setAttribute("id", usuarioL.getId());
        String showId = request.getSession().getId();
        System.out.println("Id " + usuarioL.getId());
        System.out.println("showId " + request.getSession().getAttribute("id"));
        rd = request.getRequestDispatcher("/frmPublicacion.jsp");*/
        
        
        
        conn.disconnect();

        request.setAttribute("message", msg);

        //response.sendRedirect(request.getContextPath() + "/frmPublicacion.jsp");
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
