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
        <h1>New Settings</h1>
            <p>
                <label for="first">Username: &nbsp;</label>
                <span><c:out value="${customer.username}"/></span>
            </p>
            <p>
                <label for="email">Email: &nbsp; ${customer.email}</label>

            </p>
            <p>
                <label for="address">Address: &nbsp; ${customer.address}</label>
            </p>
            <p>
                <label for="city">Email: &nbsp; ${customer.city}</label>
            </p>
            <p>
                <label for="province">Email: &nbsp; ${customer.province}</label>
            </p>
            <p>
                <label for="postalCode">Email: &nbsp; ${customer.postalCode}</label>
            </p>
            <p>
                <label for="phoneNumber">Phone Number: &nbsp;  ${customer.phoneNumber}</label>
            </p>

        <c:url value="home.do" var="menu"> </c:url>
        <p><a href="${menu}">Main Menu</a> </p>     

    </body>
</html>
