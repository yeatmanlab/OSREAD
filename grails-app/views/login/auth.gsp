<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log In - App for Literacy</title>
    <asset:stylesheet src="bootstrap.css"/>
    <asset:javascript src="bootstrap.js"/>


</head>

<body>

<div class="container">

    <h2 class="form-signin-heading">Log In</h2>
    <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" class="cssform" autocomplete="off">
	<p>
            <label for="username"><g:message code='springSecurity.login.username.label'/>:</label>
            <input type="text" class="text_" name="${usernameParameter ?: 'username'}" id="username"/>
	</p>

	<p>
            <label for="password"><g:message code='springSecurity.login.password.label'/>:</label>
            <input type="password" class="text_" name="${passwordParameter ?: 'password'}" id="password"/>
	</p>

	<p id="remember_me_holder">
            <input type="checkbox" class="chk" name="${rememberMeParameter ?: 'remember-me'}" id="remember_me" <g:if test='${hasCookie}'>checked="checked"</g:if>/>
            <label for="remember_me"><g:message code='springSecurity.login.remember.me.label'/></label>
        </p>

	<p>
            <input type="submit" id="submit" value="${message(code: 'springSecurity.login.button')}"/>
	</p>
    </form>
</div> <!-- /container -->

</body>
</html>

<script>
    function login(){
        alert("Welcome " + document.getElementById("inputEmail").value + "!");
    }
</script>
