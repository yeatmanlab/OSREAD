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
</head>

<body>
    <g:each in="${modules}" var="module">
        <div class="row" id="module">

            <div class="col-md-5">
                <h3>${module.type}</h3>
                <p>Put information about ${module.type} here.</p>

                <ul>
                    <g:each in="${module.getOutputs()}" var="output">
                        <div class="row" id="outputs">
                            <g:form>
                                <div class="col-md-5">
                                    <p>${output.dateString()}</p>
                                    <g:hiddenField name="outputID" value="${output.moduleDataID}" />

                                    <g:actionSubmit class="btn btn-primary" href="#" value="Download .CSV" action="downloadFile" />

                                </div>
                            </g:form>
                        </div>
                    </g:each>
                </ul>

            </div>

        </div>
    </g:each>
</body>
</html>