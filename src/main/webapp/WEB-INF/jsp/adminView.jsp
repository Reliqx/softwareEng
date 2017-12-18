<%-- 
    Document   : CustomerView
    Created on : 12-Dec-2017, 3:05:36 PM
    Author     : reliq
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Account</title>
    </head>
    <body>
        <h1>Welcome <c:out value="${customer.username}"/></h1>

        <div style="background-color:white;color:blue;padding:10px;">
            <ul type="square">
                <li><a href="<c:url value="createAccount.do"/>">Create Account</a></li>&nbsp;
                <li><a href="<c:url value="viewAccounts.do"/>">Delete Account</a></li>&nbsp;
                <li><a href="<c:url value="createBill.do"/>">Create Statement</a></li>&nbsp;
            </ul>


        </div>
        <c:url value="login.do" var="logout"> </c:url>
        <p><a href="${logout}">Logout</a> </p>   
    </body>
</html>
