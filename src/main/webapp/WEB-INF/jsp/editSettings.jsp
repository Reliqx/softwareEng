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
        <title>Customize Settings</title>
    </head>
    <body>
        <div class="w3-main" style="margin-left:250px">

            <div class="w3-row w3-padding-64">
                <div class="w3-twothird w3-container">
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
