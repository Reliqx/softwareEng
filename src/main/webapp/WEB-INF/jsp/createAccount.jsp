<%--
    Document   : login
    Created on : 12-Dec-2017, 2:21:35 PM
    Author     : reliq
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <title>Create Account</title>
    </head>
    <body>
        <div class="w3-main" style="margin-left:250px">

            <div class="w3-row w3-padding-64">
                <div class="w3-twothird w3-container">
                    <h1>Create Account</h1>

                    <form action="createAccount.do" method="POST">

                        <p>
                            <label> Username </label>
                            <input type="text" maxlength='15' size='15' name="username" required/>
                        </p>

                        <p>
                            <label> Password </label>
                            <input type="password" maxlength='15' size='15' name="password" required/>
                        </p>
                        <p>
                            <select id="role" name="role">
                                <option value="Administrator" selected>Administrator</option>
                                <option value="Customer">Customer</option>
                            </select><my:Required/>
                        </p>
                        <p>
                            <label> Email </label>
                            <input type="text" maxlength='45' size='45' name="email" required/>
                        </p>            <p>
                            <label> Address </label>
                            <input type="text" maxlength='45' size='45' name="address" required/>
                        </p>            <p>
                            <label> City </label>
                            <input type="text" maxlength='45' size='45' name="city" required/>
                        </p>            <p>
                            <label> Province </label>
                            <input type="text" maxlength='45' size='45' name="province" required/>
                        </p>            <p>
                            <label> Postal Code </label>
                            <input type="text" maxlength='45' size='45' name="postalCode" required/>
                        </p>            <p>
                            <label> Phone Number </label>
                            <input type="text" maxlength='45' size='45' name="phoneNumber" required/>
                        </p>
                        <p>
                            <label>&nbsp;</label>
                            <input type="submit" value="Create Account">    
                        </p>
                    </form>
                </div>
            </div>
        </div>
        <div class="w3-top">
            <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
                <a href="#" class="w3-bar-item w3-theme-l1"><img src="sheridanBank_logo.png" height="40" width="40" alt="Logo"></a>
                    <c:url value="adminHome.do" var="adminMenu"> </c:url>
                <a href="${adminMenu}" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Main Menu</a>
            </div>
        </div>   





    </body>
</html>