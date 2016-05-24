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

    <!--- audio testing @@@@@ -->
    <sm:inlinePlayer/>
    <g:javascript src="swfobject.js"/> -->

</head>

<body>
<a href="localhost:8080/assets/horse.mp3"> lolcats </a>
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

    <!-- @@@@@@      INSERTED IMAGE HERE ONLY FOR TESTING IF CAN SHOW IMAGE-->
    <g:img file="apple-touch-icon.png" />
    <g:img file="grails_logo.png" />
    <g:img file="lol.png" />
    <img src="${resource(file:'favicon.ico')}" />
    <!--<g:img absolute='true' dir='assets/images' file="apple-touch-icon.png" />-->
    <g:img absolute='true' file="apple-touch-icon.png"/>
    <!-- i have NO idea what the 'true' default base is. but i'll figure that out later -->
     <g:img base='http://localhost:8080/' file="database_add.png"/>
     <g:img base='http://localhost:8080/' file="database_add.png"/>
    <!--<g:img uri="assets/images/apple-touch-icon.png"/> -->
    <!--<img src="${resource(dir:'rain',file:'lol.png')}" /> -->
    <!-- <g:img dir="assets/images" file="lol.png" /> -->

    <audio controls>
      <source src="localhost:8080/assets/horse.mp3" type="audio/mpeg">
    </audio>
    
    <sm:playlist>
    <a href="localhost:8080/assets/horse.mp3" class="inline-playable">A song</a>
    </sm:playlist >


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
