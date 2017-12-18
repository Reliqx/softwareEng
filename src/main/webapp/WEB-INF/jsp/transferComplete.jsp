<%-- 
    Document   : transfer
    Created on : 14-Dec-2017, 7:31:31 PM
    Author     : reliq
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer</title>
    </head>
    <body>
        <h1>Transfer Completed</h1>
        <h2> Testing View </h2>
        <p><c:out value="${transferAccount.account_id}"/></p>
        <p>
            <c:out value="${transferAccount.balance}"/>
            
        </p>
        <p><a href="<c:url value="viewTransfer.do"/>">Make another Transfer?</a></p>
        <p><a href="<c:url value="home.do"/>">Main Menu</a></p>
</body>
</html>
