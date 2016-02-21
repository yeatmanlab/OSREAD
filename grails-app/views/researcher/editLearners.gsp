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
                    <g:link controller='logout'>Logout</g:link>
                </li>
                <li>
                    <g:link controller="Researcher" action="editLearners">Learners</g:link>
                </li>
                <li>
                    <g:link controller="Researcher" action="editModules">Modules</g:link> 
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
            <h1 class="page-header">Edit Learners</h1>
        </div>
    </div>
    <!-- /.row -->
    <div class="panel panel-default container">
        <h2 class="form-signin-heading">Add a Learner</h2>
        <g:form controller="researcher" action="create" class="form">
            <label for="firstName">First Name:</label><g:textField name="firstName"/><br/>

            <label for="lastName">Last Name:</label><g:textField name="lastName"/><br/>

            <label for="firstName">Date of Birth:</label><g:textField name="firstName"/><br/>

            <label for="lastName">Diagnosis:</label><g:textField name="lastName"/><br/>

            <label for="email">Email:</label><g:textField name="email"/><br/>

            <label for="password">Password:</label><g:textField name="password"/><br/>

            <g:actionSubmit value="Save" action="create"/>

        </g:form>

    </div> <!-- /container -->
    <div class="container panel panel-default">
        <h2 class="form-signin-heading">Remove a Learner</h2>
        <g:each in="${learners}" var="p">
            <div class="row" id="learners">
                <div class="col-md-5">
                    <h3>${p}</h3>
                </div>
            </div>
        </g:each>
        <g:actionSubmit value="Remove" action="create"/>
    </div>
</div>
</body>
</html>
