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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="WEB_INF/css/main.css">
        <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Transaction Balance</title>
    </head>
    <body>
        <div class="w3-main" style="margin-left:250px">

            <div class="w3-row w3-padding-64">
                <div class="w3-twothird w3-container">

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
                </div>
            </div>
        </div>
        <div class="w3-top">
            <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
                <a href="#" class="w3-bar-item w3-theme-l1"><img src="sheridanBank_logo.png" height="40" width="40" alt="Logo"></a>
                    <c:url value="home.do" var="menu"> </c:url>
                <a href="${menu}" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Main Menu</a>
            </div>
        </div>  
    </body>
</html>
