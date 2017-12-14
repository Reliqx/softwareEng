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
        <title>Transaction Balance</title>
    </head>
    <body>

        <h1>Transaction Balance for <c:out value="${customer.username}"/></h1>
        <table border="2" width="3" cellpadding="5">
            <caption>Account ID: <c:out value="${account.account_id}"/> </caption>
            <thead>
                <tr>
                    <th>Transaction ID</th>
                    <th>Description </th>
                    <th>Type (W - withdrawal or D - deposit)</th>
                    <th> Account Type </th>
                    <th> Amount </th>
                    <th> Chequing Balance </th>
                    <th> Savings Balance </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${transactList}" var="v" varStatus="s">
                    <tr>
                        <td>${v.transac_id}</td>
                        <td>${v.desc}</td>
                        <td>${v.type}</td>
                        <td>${v.account_type}</td>
                        <td>${v.amount}</td>
                        <td>${v.cheq_balance}</td>
                        <td>${v.savings_balance}</td>
                    </c:forEach>

            </tbody>
        </table>
    </body>
</html>
