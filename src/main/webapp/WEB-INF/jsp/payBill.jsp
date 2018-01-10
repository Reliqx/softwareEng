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

                    <h1>Bills for <c:out value="${customer.username}"/></h1>
                    <form name="confirmation" action="billPaid.do">
                        <p>
                            <label for="first">Bill ID: &nbsp;</label>
                            <span><c:out value="${paymentBill.billID}"/></span>
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
                    </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="w3-top">
            <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
                <a href="#" class="w3-bar-item w3-theme-l1"><img src="sheridanBank_logo.png" height="40" width="40" alt="Logo"></a>
                <a href="<c:url value="viewBills.do"/>" class="w3-bar-item w3-button w3-hide-small w3-hover-white">View Bills</a>
                <c:url value="home.do" var="menu"> </c:url>
                <a href="${menu}" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Main Menu</a>
            </div>
        </div> 
    </body>
</html>
