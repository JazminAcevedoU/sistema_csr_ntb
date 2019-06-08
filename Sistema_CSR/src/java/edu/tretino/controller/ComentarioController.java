
package edu.tretino.controller;

import edu.trentino.dao.ComentarioDao;
import edu.trentino.dao.DbConnection;
import edu.trentino.model.Comentario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComentarioController extends HttpServlet {

    
    

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

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String detalleParam = request.getParameter("detalle");
        //obtener el id de la publicacion que esté activa
        int idPublicacionParam = Integer.parseInt(request.getParameter("idpublicacion"));
        //obtener el id del usuario en sesion
        int idUsuarioParam = Integer.parseInt(request.getParameter("perfilusuario"));

        Comentario comentario = new Comentario(0);

        comentario.setDetalle_comentario(detalleParam);
        comentario.setId_publicacion(idPublicacionParam);
        comentario.setId_usuario(idUsuarioParam);
        
        // Procesamos los datos guardar en bd
        DbConnection conn = new DbConnection();

        ComentarioDao comentarioDao = new ComentarioDao(conn);
        boolean status = comentarioDao.insert(comentario);

        String msg="";
        if (status) {
            msg = "El Comentario fue guardado correctamente";
        }else{
            msg="Ocurrió un error.";
        }

        conn.disconnect();
        RequestDispatcher rd;
              
        request.setAttribute("message", msg);
        
        rd = request.getRequestDispatcher("/mensaje.jsp");
        rd.forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
