<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.12.2017
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">

    <title>Login</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href = "/resources/css/style.css" rel = "stylesheet">
    <link href = "/resources/css/bootstrap.min.css" rel = "stylesheet">
</head>

<body class="align">
<div class="login-page">
    <div class="form">
        <%
            if (request.getAttribute("logoutStr").toString().equals("true"))
                out.println("<div class='alert alert-info' role='alert'>You've been logged out successfully.</div>");
        %>
        <% if (request.getAttribute("error").toString().equals("true"))
            out.println("<div class=\"alert alert-danger\" role=\"alert\">Invalid Username or Password!</div>");
        %>
        <form class="login-form" method = "post">
            <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
            <input type="text" placeholder="username" name = "username"/>
            <input type="password" placeholder="password" name = "password"/>
            <input type = "submit" style = "background:#43A047;color:white;" value = "login"/>
        </form>
    </div>
</div>
</body>

</html>