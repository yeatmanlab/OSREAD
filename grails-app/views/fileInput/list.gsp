<html>
<head>
    <title>Module List</title>


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
                    <a href="#">My Account</a>
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
            <h1 class="page-header">Assign a Module to Student</h1>
        </div>
    </div>
    <h3>Choose a module and upload individualized content</h3><br>

    <g:form method="post"  enctype="multipart/form-data" params="['type': type, 'userID': id]" class="form">
        <g:hiddenField name="learnerID" value="${id}" />
        <div class="dialog">
            <label>Module:</label>
            <div>
                <g:radioGroup name="moduleTypes"
                              labels="${type}"
                              values="${type}">
                    <p>${it.radio} ${it.label} </p>
                </g:radioGroup>
            </div>
            <div>
                <label>Upload a Content File:</label>
                <table>
                    <tbody>
                    <tr class="prop">
                        <td valign="top" class="value ${hasErrors(bean:fileResourceInstance,field:'upload','errors')}">
                            <input type="file" id="fileUpload" name="fileUpload" />
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <br/>
            <div class="buttons">
                <g:actionSubmit class="upload btn btn-primary" value="Assign" action="upload"/>
            </div>
        </div>


    </g:form>
</div>
</body>
</html>
