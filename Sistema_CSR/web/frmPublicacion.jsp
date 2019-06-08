<%-- 
    Document   : frmPersona
    Created on : 27/05/2019, 05:26:43 PM
    Author     : JAZMIN
--%>

<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
Agregando librerías
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap_4/bootstrap.min.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
        <div class="container-fluid bg-info">
            <div class="row">
                <div class="col-3 text-center p-2">
                    <img src="http://www.trentino.edu.pe/views/images/logotrentino.png">
                </div>
                <div class="col-7 d-flex align-items-center">
                    <ul class="nav justify-content-center">
                            <li class="nav-item">
                                <a class="nav-link active text-white" href="index.html">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-white" href="persona">Persona</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-white" href="frmTipoPersona.jsp">Tipo Persona</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-white" href="frmPerfilUsuario.jsp">Perfiles</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-white" href="pbpendiente">Publicaciones Pendientes</a>
                            </li>
                        </ul>
                </div>
            </div>
        </div>
    </header>
        <div class="container mt-5">
            <div class="row">
                <div class="col-4">

                </div>
                <div class="col-8">
                    <div class="form-group row d-flex justify-content-center">
                    <h3>Registrar Nueva Publicación</h3></div>
                    <form class="mt-4" action="publicacion" method="post">
                        <div class="form-group row">
                            <label for="asunto" >Asunto</label>
                            
                                <input type="text" class="form-control border rounded-pill" name="asunto" placeholder="asunto">
                            
                        </div>
                        <div class="form-group row">
                            <label for="descripcion" >Descripcion</label>
                            <textarea maxlength="500" type="text" class="form-control border rounded-pill" name="descripcion" placeholder="descripcion"></textarea>
                        </div>
                        <div class="form-group row align-items-center">
                            <label class=" col-form-label">Tipo de Persona</label>
                            
                                <select class="custom-select form-control border rounded-pill" name="tipo_publicacion">
                                    <c:forEach items="${tipopublicacion}" var="tipop" varStatus="status">
                                        <option value="${tipop.id}">${tipop.nombre_subtipo}</option>
                                    </c:forEach>
                                </select>
                            
                        </div>
                        <div class="form-group row"> 
                        <button class="btn btn-default btn-primary my-3 border rounded-pill">Registrar</button>
                        </div>

                    </form>
                </div>
            </div>
            </form>
        </div>
    </body>
</html>
