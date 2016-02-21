<%--
  Created by IntelliJ IDEA.
  User: josephkesting
  Date: 2/16/16
  Time: 7:06 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Module Successfully Assigned</title>

    <asset:stylesheet src="bootstrap.css"/>
    <asset:javascript src="bootstrap.js"/>
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">



            <ul class="nav navbar-nav">
                <li>
                    <g:link controller='logout'>Logout</g:link>
                </li>
                <li>
                    <g:link controller="Researcher" action="editLearners">Learners</g:link>
                </li>
                <li>
                    <a href="#">Modules</a>
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
            <h1 class="page-header">Module Successfully Assigned</h1>
        </div>
    </div>

    <g:form>
        <g:hiddenField name="id" value="${id}" />
        <g:actionSubmit class="btn btn-primary" value="Assign another module" action="list"/>
    </g:form>
    <g:form controller="researcher">
        <g:actionSubmit class="btn btn-primary" value="Return to home" action="home"/>
    </g:form>
</div>
</body>
</html>
