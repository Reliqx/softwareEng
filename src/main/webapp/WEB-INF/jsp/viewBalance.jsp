<%-- 
    Document   : viewBalance
    Created on : 12-Dec-2017, 10:14:56 PM
    Author     : reliq
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Balance</title>
    </head>
    <body>

        <h1>Account Balance for <c:out value="${customer.username}"/></h1>
               <table border="2" width="3" cellpadding="5">
            <caption>Account ID: <c:out value="${account.account_id}"/> </caption>
            <thead>
                <tr>
                    <th>Account</th>
                    <th>ID </th>
                    <th>Balance</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Chequing: </td>
                    <td><c:out value="${chequing_acc.cheq_id}"/></td>
                    <td><c:out value="${chequing_acc.balance}"/></td>
                </tr>
                <tr>
                    <td>Saving: </td>
                    <td><c:out value="${savings_acc.saving_id}"/></td>
                    <td><c:out value="${savings_acc.balance}"/></td>
                </tr>

            </tbody>
        </table>
    </body>
</html>
