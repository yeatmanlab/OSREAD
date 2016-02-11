<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Register</title>
    <asset:stylesheet src="bootstrap.css"/>
    <asset:javascript src="bootstrap.js"/>


</head>

<body>

<div class="container">
    <h2 class="form-signin-heading">Register</h2>
    <g:form controller="researcher" action="create">
        <label for="firstName">First Name:</label><g:textField name="firstName"/><br/>

        <label for="lastName">Last Name:</label><g:textField name="lastName"/><br/>

        <label for="email">Email:</label><g:textField name="email"/><br/>

        <label for="password">Password:</label><g:textField name="password"/><br/>

        <g:actionSubmit value="Save" action="create"/>

    </g:form>

</div> <!-- /container -->


</body>
</html>

<script>
    function register(){
        if (document.getElementById("inputPassword").value != document.getElementById("confirmPassword").value){
            alert("Passwords don't match!");
        } else {
            alert("Welcome " + document.getElementById("inputFName").value + " " + document.getElementById("inputLName").value + "!");
        }
    }
</script>