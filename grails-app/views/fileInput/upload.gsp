<%--
  Created by IntelliJ IDEA.
  User: josephkesting
  Date: 2/16/16
  Time: 7:06 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Module Successfully Assigned</title>
</head>

<body>
    <h3>Module Successfully Assigned ${id}</h3>

    <g:form>
        <g:hiddenField name="id" value="${id}" />
        <g:actionSubmit value="Assign another module" action="list"/>
    </g:form>
    <g:form controller="researcher">
        <g:actionSubmit value="Return to home" action="home"/>
    </g:form>
</body>
</html>