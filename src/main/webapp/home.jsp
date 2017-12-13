<%-- 
    Document   : home
    Created on : 12-Dec-2017, 2:17:44 PM
    Author     : reliq
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/main.css">

        <title>Sheridan Banking </title>
    </head>
    <body>
        <h1>Welcome To Sheridan Bank!</h1>
        <!--Redirect to the specific pages -->
        <p><a href="<c:url value="login.jsp"/>">Login</a></p>
        <p><a href="<c:url value="register.jsp"/>">Register</a></p>

    </body>
</html>
