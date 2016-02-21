<%--
  Created by IntelliJ IDEA.
  User: josephkesting
  Date: 2/6/16
  Time: 6:21 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>Download File</title>

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
                    <a href="#">Log Out</a>
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
            <h1 class="page-header">Student ${id} Performance Data</h1>
        </div>
    </div>

    <g:each in="${modules}" var="module">
        <div class="row" id="module">

            <div class="col-md-5">
                <h3>${module.type}</h3>


                    <g:each in="${module.getOutputs()}" var="output">
                        <div class="row" id="outputs">
                            <g:form>
                                <div class="col-md-5">
                                    <p>Date Completed: ${output.dateString()}</p>
                                    <g:hiddenField name="outputID" value="${output.moduleDataID}" />

                                    <g:actionSubmit class="btn btn-primary" href="#" value="Download .CSV" action="downloadFile" />

                                </div>
                            </g:form>
                        </div>
                    </g:each>


            </div>

        </div>
    </g:each>
</div>
</body>
</html>
