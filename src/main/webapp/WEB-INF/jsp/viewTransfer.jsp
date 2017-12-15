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
        <h1>Transfer Funds</h1>
        <form method="get" action="<c:url value="confirmTransfer.do"/>">
            <p>
                <label for="first">Account No:</label>
                <input type="text" name="accountNo" value="" />
            </p>
            <p>
                <label for="amount">Amount</label>
                <input type="text" name="amount" value="" />
            </p>
            <p>
                <label for="account_target">Account to Transfer TO: </label>
                <select name="accountTarget">
            <option>Chequing</option>
            <option>Savings</option>
                        </select>

        </p>
        <p>
            <label for="account_type">Account To Transfer FROM:</label>
            <select name="account_type">
                <option>Chequing  <c:out value="${chequing_acc.balance}"/></option>
                <option>Savings  <c:out value="${savings_acc.balance}"/></option>
            </select>
        </p>

        <p>
            <label>&nbsp;</label>
            <input type="submit" value="Next">
        </p>
    </form>
</body>
</html>
