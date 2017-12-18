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
        <form name="confirmation" action="billPaid.do">
            <p>
                <label for="first">Bill ID: &nbsp;</label>
                <span><c:out value="${paymentBill.bilID}"/></span>
            </p>
            <p>
                <label for="first">Bill Amount: &nbsp;</label>
                <span><c:out value="${paymentBill.amount}"/></span>
            </p>
            <label for="account_target">Account to Transfer TO: </label>
            <select name="payment_account">
                <option>Chequing ${chequing_acc.balance}</option>
                <option>Savings ${savings_acc.balance}</option>
            </select>
            <input type="submit" value="Pay" />
        </form>
        <c:url value="viewBills.do" var="viewBills"> </c:url>
        <p><a href="${viewBills}">View Bills</a> </p>
        <c:url value="home.do" var="menu"> </c:url>
        <p><a href="${menu}">Main Menu</a> </p>
    </tbody>
</table>
</body>
</html>
