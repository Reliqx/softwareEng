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
        <h1>Confirm Your Transfer</h1>
        <form method="get" action="<c:url value="makeTransfer.do"/>">
            <p>
                <label for="first">Account No: &nbsp;</label>
                <span style="background-color:gray"><c:out value="${transfer.accountNoTransfer}"/></span>
            </p>
            <p>
                <label for="amount">Amount: &nbsp; </label>
                <span style="background-color:gray"><c:out value="${transfer.amountTransferred}"/></span>
            </p>
            <p>
                <label for="account_type">Account To Transfer To: &nbsp;</label>
                <span style="background-color:gray;"><c:out value="${transfer.accountTarget}"/></span>
            </p>
            <p>
                <label for="account_type">Account To Transfer From: &nbsp;</label>
                <span style="background-color:gray;"><c:out value="${transfer.accountType}"/></span>
            </p>

            <p>
                <label>&nbsp;</label>
                <input type="submit" value="Transfer Funds">
            </p>
        </form>
    </body>
</html>
