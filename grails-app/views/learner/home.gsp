<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home</title>

    <asset:stylesheet src="bootstrap.css"/>
    <asset:javascript src="bootstrap.js"/>

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <ul class="nav navbar-nav">
                <li>
                    <a href="#">Log Out</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">

    <!-- Page Heading -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">App For Literacy
                <small>Welcome, ${fname}!</small>
            </h1>
        </div>
    </div>
<!-- /.row -->

    <div>
        <g:if test="${modules.length > 0}">
        <h2>You have new activities to do!</h2>
        <h3>Choose an activity below.</h3>
            <g:each in="${modules}" var="p">
                <div class="row" id="modules">
                    <div class="col-md-5">
                        <g:link><h5>${p}</h5></g:link>
                        <g:link class="btn btn-primary">Play ${p}<span class="glyphicon glyphicon-chevron-right"></span></g:link>
                    </div>
                </div>
            </g:each>
            <hr>
        </g:if>
        <g:else>
            <h2>You do not have new activities yet!</h2>
            <h3>Check back soon!<h3>
        </g:else>
    </div>

</div>
<!-- /.container -->

</body>

</html>

