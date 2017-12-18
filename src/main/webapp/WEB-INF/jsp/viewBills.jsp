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

        <h1>Bills for <c:out value="${customer.username}"/></h1>
        <table border="2" width="3" cellpadding="5">
            <caption>Account ID: <c:out value="${account.account_id}"/> </caption>
            <thead>
                <tr>
                    <th> Count </th>
                    <th>Bill ID</th>
                    <th>Amount</th>
                    <th>Payment Status</th>
                    <th>Option</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${billList}" var="v" varStatus="s">
                    <tr>
                        <td>${s.count}</td>
                        <td>${v.bilID}</td>
                        <td>${v.amount}</td>
                        <td>${v.paid}</td>
                        <c:if test = "${v.paid == 'NO'}">
                        <c:url value="payBill.do" var="ref_pay">
                            <c:param name="bill_id" value="${v.bilID}"/>
                        </c:url>
                        <td><a href="${ref_pay}">Pay</a></td>
                        </c:if>
                    </c:forEach>

            </tbody>
        </table>
            <p> ${cheq_test.balance}</p>
    </body>
</html>
