<%-- 
    Document   : registro
    Created on : 29-abr-2016, 19:00:26
    Author     : Dani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro | Class Royal</title>
        <!-- Bootstrap Core CSS -->
        
        <jsp:include page="../css.jsp"/>
    </head>
    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                <!--    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button> -->
                    <a class="navbar-brand" href="index.html">CLASS ROYAL</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <!-- Page Content -->
        <div class="container panel padding-twice">

            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Registro
                        <small>registrate en tan solo 35 segundos!</small>
                    </h1>
                <!--    <ol class="breadcrumb">
                        <li><a href="index.html">Home</a>
                        </li>
                        <li class="active">Full Width Page</li>
                    </ol>
                -->
                </div>
            </div>
            <!-- /.row -->

            <!-- Content Row -->
            <div class="row">
                <div class="col-lg-12">
                    <form id="registro" name="registro" method="POST" action="${contextpath}/usuarios/registro.html">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="control-group form-group">
                                    <div class="controls">
                                        <label>Nombre del restaurante:</label>
                                        <input class="form-control" id="nombre" name="nombre" value=""/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="control-group form-group">
                                    <div class="controls">
                                        <label>Direccion:</label>
                                        <input class="form-control" id="direccion" name="direccion" value=""/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="control-group form-group">
                                    <div class="controls">
                                        <label>Telefono:</label>
                                        <input class="form-control" id="telefono" name="telefono" value=""/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="control-group form-group">
                                    <div class="controls">
                                        <label>Email:</label>
                                        <input class="form-control" id="email" name="email" value=""/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="control-group form-group">
                                    <div class="controls">
                                        <label>Web:</label>
                                        <input class="form-control" id="web" name="web" value=""/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="control-group form-group">
                                    <div class="controls">
                                        <label>Username:</label>
                                        <input class="form-control" id="username" name="username" value=""/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="control-group form-group">
                                    <div class="controls">
                                        <label>Password:</label>
                                        <input type="password" class="form-control" id="password" name="password" value=""/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="control-group form-group">
                                    <div class="controls">
                                        <label>Confirma la password:</label>
                                        <input type="password" class="form-control" id="cfpassword" name="cfpassword" value=""/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="control-group form-group">
                                    <div class="controls">
                                        <input type="button" class="btn btn-primary fright" value="Envía" id="submit"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- /.row -->
            <hr>
        </div>
        <script type="text/javascript">
            $("#submit").click(function() {
                $.ajax({
                    type: "POST",
                    url: "${contextpath}/usuarios/registro.html", 
                    data: $("#registro").serialize(),
                    success: function(result){
                        alert("Restaurante registrado correctamente");
                        window.location = "${contextpath}/home.html";
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        alert("UPS! ha habido un error en el proceso. Vuelva a intentarlo o contacte con el equipo técnico.");
                    }
                });
            });
        </script>
        <!-- /.container -->
        <jsp:include page="../scripts.jsp"/>
    </body>
</html>
