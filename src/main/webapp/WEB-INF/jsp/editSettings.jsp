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
        <title>Customize Settings</title>
    </head>
    <body>
        <h1>Customize Settings</h1>
        <form method="get" action="<c:url value="customize.do"/>">
            <p>
                <label for="first">Username: &nbsp;</label>
                <span><c:out value="${customer.username}"/></span>
            </p>
            <p>
                <label for="amount">Email: &nbsp; </label>
                <input type="text" name="email" value="${customer.email}" />

            </p>
            <p>
                <label for="account_type">Address: &nbsp;</label>
                <input type="text" name="address" value="${customer.address}" />
            </p>
            <p>
                <label for="account_type">City: &nbsp;</label>
                <input type="text" name="city" value="${customer.city}" />
            </p>
            <p>
                <label for="account_type">Province: &nbsp;</label>
                <input type="text" name="province" value="${customer.province}" />
            </p>
            <p>
                <label for="account_type">Postal Code: &nbsp;</label>
                <input type="text" name="postalcode" value="${customer.postalCode}" />
            </p>
            <p>
                <label for="account_type">Phone Number: &nbsp;</label>
                <input type="text" name="phonenum" value="${customer.phoneNumber}" />
            </p>
            <p>
                <label>&nbsp;</label>
                <input type="submit" value="Edit Info">
            </p>
        </form>

        <c:url value="home.do" var="menu"> </c:url>
        <p><a href="${menu}">Main Menu</a> </p>     

    </body>
</html>
