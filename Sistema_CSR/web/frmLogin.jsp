<%-- 
    Document   : frmLogin
    Created on : 31/05/2019, 06:56:30 PM
    Author     : JAZMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="css/bootstrap_4/bootstrap.min.css" rel="stylesheet">
    <title>Document</title>
    <style>
            html, body, .container-position-center{
                height: 100% !important;
                position: relative;
                background-color: #2E5287;
            }
        </style>

</head>

<body>
    <section class="container-position-center d-flex align-items-center justify-content-center">
            <div class="card p-4 col-4">
                <div class="col-12 d-flex justify-content-center">
                    <div class="col-6 d-flex justify-content-end">
                        <img src="css/img/usuario3.png" width="100%" height="100%">
                    </div> 
                </div>
                    <div class=" col-12 d-flex justify-content-center mt-5">
                        <form class="form-signin" action="sesion" method="POST">
                            <!--USUARIO-->
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label px-0">Usuario</label>
                                <div class="col-sm-8 p-0">
                                    <input type="text" class="form-control" name="correo" placeholder="usuario">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label px-0">Clave</label>
                                <div class="col-sm-8 p-0">
                                    <input type="Password" class="form-control" name="contrasenia" placeholder="clave">
                                </div>
                            </div>
                            <p class="text-danger">${requestScope.message}</p>
                            <div class="form-group row d-flex align-items-center justify-content-center mt-5">
                                <button class="btn btn-primary mb-2 form-control">Ingresar</button>
                            </div>
                            <div class="form-group row d-flex align-items-center justify-content-center mt-5 text-center">
                                <a href="persona">Crear Cuenta</a>
                            </div>

                        </form>
                    </div>
            </div>
        </section>
</body>

</html>
