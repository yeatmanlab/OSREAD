<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home</title>

    <!-- How the Page is Styled-->
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
                    <g:link action="viewProgress">View Your Progress!</g:link>
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


    <g:if test="${modules.size() > 0}">
    <h2>You have new activities to do!</h2>
    <h3>Choose an activity below.</h3>
        <g:each in="${modules}" var="p">

                <div class="row" id="modules">
                    <div class="col-md-5">
                        <g:form>
                            <h5>${p.type}</h5>
                            <g:hiddenField name="id" value="${p.moduleId}" />
                            <g:hiddenField name="type" value="${p.type}" />
                            <g:hiddenField name="test" value="test" />
                            <g:actionSubmit value="Play ${p.type}" action="startModule" class="btn btn-primary" />
                        </g:form>
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
<!-- /.container -->

</body>

</html>
