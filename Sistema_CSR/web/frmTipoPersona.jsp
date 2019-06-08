<%-- 
    Document   : frmTipoPersona
    Created on : 24/05/2019, 07:21:53 PM
    Author     : JAZMIN
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap_4/bootstrap.min.css" rel="stylesheet">

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

                </div>
                <div class="col-8">
                    <h3>Registro Tipos de Persona</h3>
                    <form class="mt-4" action="tipopersona" method="post">
                        <label for="tipo_persona">Tipo persona</label>
                        <input type="text" class="form-control border rounded-pill" name="tipo_persona" required
                            id="tipo_persona" value="" placeholder="perfil nuevo">
                        <button type="submit"
                            class="btn btn-default btn-primary mt-5 border rounded-pill">Guardar</button>
                    </form>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
