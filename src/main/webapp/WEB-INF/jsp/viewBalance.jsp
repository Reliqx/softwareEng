<%-- 
    Document   : viewBalance
    Created on : 12-Dec-2017, 10:14:56 PM
    Author     : reliq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Balance</title>
    </head>
    <body>
        <h1>Account Balance</h1>
                <table border="2" width="3" cellpadding="2">
            <caption>Account ID: <c:out value="${account.account_id}"/></caption>
            <thead>
                <tr>
                    <th>Accounts</th>
                    <th>Balance</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Chequing: <c:out value="${chequing_acc.cheq_id}"/></td>
                    <td><c:out value="${chequing_acc.balance}"/></td>
                </tr>
                <!--<tr>
                    <td>Saving: <c:out value="${saving_acc.saving_id}"/></td>
                    <td><c:out value="${chequing_acc.balance}"/></td>
                </tr>
-->
            </tbody>
        </table>
    </body>
</html>
