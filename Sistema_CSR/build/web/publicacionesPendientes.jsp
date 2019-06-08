
<%-- 
    Document   : PublicacionesPendientes
    Created on : 06/06/2019, 01:02:28 PM
    Author     : JAZMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap_4/bootstrap.min.css" rel="stylesheet">
        <link href="css/fontawesome-free-5.8.2-web/css/all.css" rel="stylesheet">
        <title>JSP Page</title>

        <style>
            .card .date { 
                position: absolute;
                right: 2em;
                top: 0.6em;
            }
        </style>
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
        <main>
            <div class="container mt-5">
                <div class="row">
                    <div class="col-4">
                        //panel de menu
                    </div>
                    <div class="col-8">
                        <c:forEach items="${pbpendientes}" var="pb" varStatus="status">
                            <div class="col-12 col-md-12 mb-4">
                                <div class="card">
                                    <small class="date">
                                        <i>${pb.fecha_envio}</i>
                                    </small>
                                    <div class="card-body d-flex flex-row">
                                        <div class="p-2">
                                            <img class="rounded-circle" src="http://lorempixel.com/50/50/sports/2/">
                                        </div>
                                        <div class="p-2">
                                            <div class="d-flex justify-content-between">
                                                <span class="font-weight-bolder">
                                                    <b>${pb.asunto}</b>
                                                </span>
                                            </div>
                                            <small>
                                                ${pb.nombre} ${pb.apellido}
                                            </small>
                                            <p class="pt-2">
                                                ${pb.descripcion}
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>
        </main>
    </body>
</html>
