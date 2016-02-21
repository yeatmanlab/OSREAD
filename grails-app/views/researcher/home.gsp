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


    <g:each in="${learners}" var="user">
        <div class="row" id="learners">
            <g:form>
                <div class="col-md-5">

                    <h3>${user.firstName} ${user.lastName}</h3>
                    %{--<p>Put information about ${learner.firstName} here.</p>--}%

                    <g:hiddenField name="learnerID" value="${user.getId()}" />

                    <g:actionSubmit class="btn btn-primary" href="#" value="View Progress" action="progress" />

                    <g:actionSubmit class="btn btn-primary" href="#" value="Assign Module" action="assign" />

                </div>
            </g:form>
        </div>
    </g:each>
    <hr>

</div>
<!-- /.container -->

</body>

</html>

