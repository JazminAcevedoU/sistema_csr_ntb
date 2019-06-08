/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tretino.controller;

import edu.trentino.dao.DbConnection;
import edu.trentino.dao.TipoPersonaDao;
import edu.trentino.model.TipoPersona;
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
public class TipoPersonaController extends HttpServlet {

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
        String tipo_personaParam = request.getParameter("tipo_persona");
        
        
        TipoPersona tipoPersona = new TipoPersona(0);
        
        tipoPersona.setTipo_persona(tipo_personaParam);
        
        // Procesamos los datos guardar en bd
        
        DbConnection conn = new DbConnection();
        
        TipoPersonaDao tipoPersonaDao = new TipoPersonaDao(conn);
        boolean status = tipoPersonaDao.insert(tipoPersona);
        
        String msg="";
        if (status) {
            msg = "El tipo de persona fue guardado correctamente";
        }else{
            msg="Ocurrió un error. No fue guardada";
        }
        
        conn.disconnect();
        RequestDispatcher rd;
        
               
        request.setAttribute("message",msg);
        rd = request.getRequestDispatcher("/mensaje.jsp");
        rd.forward(request, response);
        
        // Mostrar los datos 
        
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
