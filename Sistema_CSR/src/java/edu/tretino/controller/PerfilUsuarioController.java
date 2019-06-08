/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tretino.controller;

import edu.trentino.dao.DbConnection;
import edu.trentino.dao.PerfilUsuarioDao;
import edu.trentino.model.PerfilUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JAZMIN
 */
public class PerfilUsuarioController extends HttpServlet {

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
        
        //Recibir parametros
        String perfil_usuarioParam = request.getParameter("perfil_usuario");
        
        
        PerfilUsuario perfilUsuario = new PerfilUsuario(0);
        
        perfilUsuario.setNombre_perfil(perfil_usuarioParam);
                
        DbConnection conn = new DbConnection();
        
        PerfilUsuarioDao tipoPersonaDao = new PerfilUsuarioDao(conn);
        boolean status = tipoPersonaDao.insert(perfilUsuario);
        
        String msg="";
        if (status) {
            msg = "El perfil fue guardado correctamente";
        }else{
            msg="Ocurrió un error. La vacante no fue guardada";
        }
        
        conn.disconnect();
        RequestDispatcher rd;
        
               
        request.setAttribute("message",msg);
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
