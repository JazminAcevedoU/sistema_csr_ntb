/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tretino.controller;

import edu.trentino.dao.DbConnection;
import edu.trentino.dao.LoginDao;
import edu.trentino.dao.PublicacionDao;
import edu.trentino.dao.TipoPublicacionDao;
import edu.trentino.model.Publicacion;
import edu.trentino.model.TipoPublicacion;
import edu.trentino.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class PublicacionController extends HttpServlet {

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
        TipoPublicacionDao tipoPublicacionDao = new TipoPublicacionDao(conn);

        //traer las ultimas
        List<TipoPublicacion> listaTipoPublicacion = tipoPublicacionDao.getTipoPublicacion();
        conn.disconnect();
        request.setAttribute("tipopublicacion", listaTipoPublicacion);

        rd = request.getRequestDispatcher("/frmPublicacion.jsp");
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
        
        String asuntoParam = request.getParameter("asunto");
        String descripcionParam = request.getParameter("descripcion");
        //int valorizacionParam = Integer.parseInt(request.getParameter("valorizacion"));
        //int estadoParam = Integer.parseInt(request.getParameter("estado"));
        int tipopublicacionParam = Integer.parseInt(request.getParameter("tipo_publicacion"));
              
        //int idusuarioParam = (int) request.getSession().getAttribute("usr");
        
        HttpSession session=request.getSession();
        int userid =(int) session.getAttribute("user");
        
        Publicacion publicacion = new Publicacion(0);
        
        publicacion.setAsunto(asuntoParam);
        publicacion.setDescripcion(descripcionParam);
        //publicacion.setEstado(estadoParam);
        publicacion.setIdSubTipoPublicacion(tipopublicacionParam);
        publicacion.setIdUsuario(userid);
        
        
        
        
        System.out.println("ID DE USUARIO LOGEADO");
        System.out.println(userid);
        
        
        // Procesamos los datos guardar en bd
        
        DbConnection conn = new DbConnection();
        
        PublicacionDao publicacionDao = new PublicacionDao(conn);
        boolean status = publicacionDao.insert(publicacion);
        
        //Preparamos un mensaje para el Usuario
        String msg="";
        if (status) {
            msg = "La publicacion fue enviada correctamente";
        }else{
            msg="Ocurrió un error. La publicacion no fue enviada";
        }
        
        conn.disconnect();
        RequestDispatcher rd;
        
        //Compartimos la variable msg para poder
// acceder desde la vista ocon expression language        
        request.setAttribute("message",msg);
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
