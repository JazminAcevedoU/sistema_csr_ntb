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
        <main>
            <div class="container mt-5 d-flex justify-content-center">
                <div class="row">
                    <div class="card p-4 mb-5">
                        <div class="col-12">
                            <h3 class="text-center">Registrar nueva Cuenta</h3>
                            <form class="mt-4" action="persona" method="post">
                                <div class="form-group row">
                                    <label for="nombre">Nombre</label>
                                    <input type="text" class="form-control border rounded-pill" name="nombre" required
                                           id="nombre" value="" placeholder="nombres">
                                </div>
                                <div class="form-group row">
                                    <label for="apellido">Apellido</label>
                                    <input type="text" class="form-control border rounded-pill" name="apellido" required
                                           id="apellido" value="" placeholder="apellidos">
                                </div>
                                <div class="form-group row d-flex justify-content-between">
                                    <div class="col-5 p-0">
                                        <label for="dni">DNI</label>
                                        <input type="text" class="form-control border rounded-pill" name="dni" required id="dni"
                                               value="" placeholder="dni">
                                    </div>
                                    <div class="col-5 p-0">
                                        <label for="telefono">Telefono</label>
                                        <input type="text" class="form-control border rounded-pill" name="telefono" required
                                               id="telefono" value="" placeholder="telefono">
                                    </div>

                                </div>

                                <div class="form-group row">
                                    <label for="telefono">Tipo de Persona</label>
                                    <select class="custom-select form-control border rounded-pill" name="tipodepersona">
                                        <c:forEach items="${tipoPersona}" var="tipoPersonas" varStatus="status">
                                            <option value="${tipoPersonas.id}">${tipoPersonas.tipo_persona}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <!--USUARIO-->
                                <div class="form-group row">
                                    <label for="correo">Correo</label>
                                    <input type="text" class="form-control border rounded-pill" name="correo" required
                                           id="correo" value="" placeholder="correo">
                                </div>
                                <div class="form-group row">
                                    <label for="contrasenia">Contraseña</label>
                                    <input type="password" class="form-control border rounded-pill" name="contrasenia" required
                                           id="contrasenia" value="" placeholder="Contraseña">
                                </div>
                                <div class="form-group row">
                                    <label for="perfilusuario">Perfil del Usuario</label>
                                    <select class="custom-select form-control border rounded-pill" name="perfilusuario">
                                        <c:forEach items="${perfilUsuario}" var="perfil" varStatus="status">
                                            <option value="${perfil.id}">${perfil.nombre_perfil}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group row"> 
                                    <button type="submit"
                                            class="btn btn-default btn-primary my-3 border rounded-pill">Registrar</button>
                                </div>

                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </main>
    </body>

</html>
