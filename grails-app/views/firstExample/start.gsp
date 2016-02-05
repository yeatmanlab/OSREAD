<%--
  Created by IntelliJ IDEA.
  User: josephkesting
  Date: 1/23/16
  Time: 6:02 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sample Module Input</title>
</head>

<body>
    <ul>
        <g:each in="${lsOut}" var="it">
            <li>${it}</li>
        </g:each>
    </ul>

    <g:form params="[words: lsOut]">
        <g:actionSubmit value="submit" />
    </g:form>
</body>
</html>