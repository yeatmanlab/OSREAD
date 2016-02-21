<%--
  Created by IntelliJ IDEA.
  User: Erin P
  Date: 2/11/2016
  Time: 12:58 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>View Progress</title>

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
                    <g:link action="viewProgress">View Your Progress!</g:link>
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
            <h1 class="page-header">Progress</h1>
        </div>
        <div>
            <p>You have completed 0 lessons so far! Keep going!</p>
        </div>
        <br/>
        <div>
            <label>Feedback from your instructor:</label>
            <ul>
                <li>You're doing great! Keep it up!</li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>