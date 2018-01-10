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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="WEB_INF/css/main.css">
        <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Transfer</title>
    </head>
    <body>
        <div class="w3-main" style="margin-left:250px">

            <div class="w3-row w3-padding-64">
                <div class="w3-twothird w3-container">
                    <h1>Confirm Your Transfer</h1>
                    <form method="get" action="<c:url value="makeTransfer.do"/>">
                        <p>
                            <label for="first">Account No: &nbsp;</label>
                            <span><c:out value="${transfer.accountNoTransfer}"/></span>
                        </p>
                        <p>
                            <label for="amount">Amount: &nbsp; </label>
                            <span><c:out value="${transfer.amountTransferred}"/></span>
                        </p>
                        <p>
                            <label for="account_type">Account To Transfer To: &nbsp;</label>
                            <span><c:out value="${transfer.accountTarget}"/></span>
                        </p>
                        <p>
                            <label for="account_type">Account To Transfer From: &nbsp;</label>
                            <span><c:out value="${transfer.accountType}"/></span>
                        </p>

                        <p>
                            <label>&nbsp;</label>
                            <input type="submit" value="Transfer Funds">
                        </p>
                    </form>
                </div>
            </div>
        </div>
        <div class="w3-top">
            <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
                <a href="#" class="w3-bar-item w3-theme-l1"><img src="sheridanBank_logo.png" height="40" width="40" alt="Logo"></a>
                <a href="<c:url value="viewTransfer.do"/>" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Edit Transfer</a>
                    <c:url value="home.do" var="menu"> </c:url>
                <a href="${menu}" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Main Menu</a>
            </div>
        </div>   

    </body>
</html>
