<%-- 
    Document   : viewSummary
    Created on : 12-Dec-2017, 5:59:46 PM
    Author     : reliq
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AccountSummary</title>
    </head>
    <body>
        <h1>Account Summary for <c:out value="${customer.username}"/> </h1>
        <h2><c:out value="${customer.user_id}"/> </h2>
        <table border="2" width="3" cellpadding="2">
            <caption>Account ID: <c:out value="${account.account_id}"/></caption>
            <thead>
                <tr>
                    <th>Accounts</th>
                    <th>Account ID</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Chequing</td>
                    <td> <c:out value="${account.cheq_id}"/></td>
                </tr>
                <tr>
                    <td>Saving</td>
                    <td> <c:out value="${account.saving_id}"/></td>
                </tr>

            </tbody>
        </table>
        <c:url value="home.do" var="menu"> </c:url>
        <p><a href="${menu}">Main Menu</a> </p>   
    </body>
</html>
