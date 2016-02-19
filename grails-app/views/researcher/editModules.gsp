<%--
  Created by IntelliJ IDEA.
  User: Erin P
  Date: 2/10/2016
  Time: 10:28 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Learners</title>

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
                <li>
                    <g:link controller="Researcher" action="editLearners">Learners</g:link>
                </li>
                <li>
                    <g:link controller="Researcher" action="home">Home</g:link>
                </li>

            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<div class="container">

    <!-- Page Heading -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Edit Modules</h1>
        </div>
    </div>
    <!-- /.row -->
    <div class="panel panel-default container">
        <h2 class="form-signin-heading">Add a Module</h2>

    </div> <!-- /container -->
    <div class="container panel panel-default">
        <h2 class="form-signin-heading">Remove a Module</h2>
    </div>
</div>
</body>
</html>