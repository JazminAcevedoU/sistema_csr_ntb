/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tretino.controller;

import edu.trentino.dao.DbConnection;
import edu.trentino.dao.PerfilUsuarioDao;
import edu.trentino.dao.PersonaDao;
import edu.trentino.dao.TipoPersonaDao;
import edu.trentino.dao.UsuarioDao;
import edu.trentino.model.PerfilUsuario;
import edu.trentino.model.Persona;
import edu.trentino.model.TipoPersona;
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
public class PersonaController extends HttpServlet {

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
        TipoPersonaDao tipoPersonaDao = new TipoPersonaDao(conn);
        PerfilUsuarioDao perfilUsuarioDao = new PerfilUsuarioDao(conn);

        List<TipoPersona> listaTipoPersona = tipoPersonaDao.getTipoPersona();
        List<PerfilUsuario> listaPerfilUsuario = perfilUsuarioDao.getPerfilUsuario();

        //************
        
        conn.disconnect();
        request.setAttribute("perfilUsuario", listaPerfilUsuario);
        //************
        request.setAttribute("tipoPersona", listaTipoPersona);


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

        String nombreParam = request.getParameter("nombre");
        String apellidoParam = request.getParameter("apellido");
        String dniParam = request.getParameter("dni");
        String telefonoParam = request.getParameter("telefono");
        int tipoPersonaParam = Integer.parseInt(request.getParameter("tipodepersona"));

        
        String correoParam = request.getParameter("correo");
        String contraseniaParam = request.getParameter("contrasenia");
        int perfilUsuarioParam = Integer.parseInt(request.getParameter("perfilusuario"));

        Persona persona = new Persona(0);

        persona.setNombre(nombreParam);
        persona.setApellido(apellidoParam);
        persona.setDni(dniParam);
        persona.setTelefono(telefonoParam);
        persona.setId_tipo_persona(tipoPersonaParam);
        
        Usuario usuario = new Usuario();
        usuario.setCorreo(correoParam);
        usuario.setContrasenia(contraseniaParam);
        usuario.setId_perfil(perfilUsuarioParam);
    
        persona.setUsuario(usuario);
        
        
        System.out.println(persona);

        // Procesamos los datos guardar en bd
        DbConnection conn = new DbConnection();

        PersonaDao personadao = new PersonaDao(conn);
        boolean status = personadao.insert(persona);

        boolean statusUsuario = false;
        if (status) {
            UsuarioDao usuarioDao = new UsuarioDao(conn);
            statusUsuario = usuarioDao.insert(persona);
        }
        //Preparamos un mensaje para el Usuario
        String msg = "";
        if (statusUsuario) {
            msg = "La persona fue guardada correctamente";
        } else {
            msg = "Ocurrió un error. La persona no fue guardada";
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
