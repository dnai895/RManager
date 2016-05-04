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
        <title>Login | RManager</title>
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
                    <a class="navbar-brand" href="index.html">RMANAGER</a>
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
        <div class="container panel padding-fourth">

            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Login
                      <!--  <small>registrate en tan solo 35 segundos!</small>-->
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
                    <form id="login" name="login" method="POST" action="${contextpath}/usuarios/login.html">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="control-group form-group">
                                    <div class="controls">
                                        <label>Username:</label>
                                        <input class="form-control" id="username" name="username" value=""/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="control-group form-group">
                                    <div class="controls">
                                        <label>Password:</label>
                                        <input type="password" class="form-control" id="passwd" name="passwd" value=""/>
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
                    url: "${contextpath}/usuarios/login.html", 
                    data: $("#login").serialize(),
                    success: function(result){
                        if(result === "ok") {
                            alert("¡Login OK!");
                        } else {
                            alert("¡Datos incorrectos!");
                        }
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
