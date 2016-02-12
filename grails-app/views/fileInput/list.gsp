<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>FileResource List</title>
</head>
<body>
<div class="nav">
    <span class="menuButton"><a class="home" href="/">Home</a></span>
</div>
<div class="body">

    <h1>File Upload:</h1><br>

    <g:form method="post"  enctype="multipart/form-data" params="['type': type]">
        <div class="dialog">
            <table>
                <tbody>
                <tr class="prop">
                    <td valign="top" class="name">
                        <label for="fileUpload">Upload:</label>
                    </td>
                    <td valign="top" class="value ${hasErrors(bean:fileResourceInstance,field:'upload','errors')}">
                        <input type="file" id="fileUpload" name="fileUpload" />
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div>
            <g:radioGroup name="moduleTypes"
                          labels="${type}"
                          values="${type}">
                <p>${it.radio} ${it.label} </p>
            </g:radioGroup>
        </div>
        <div class="buttons">
            <span class="button"><g:actionSubmit class="upload" value="Upload" action="upload" /></span>
        </div>
    </g:form>
</div>
</body>
</html>
