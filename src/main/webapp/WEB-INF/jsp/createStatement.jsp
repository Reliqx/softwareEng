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
        <title>Create Account</title>
    </head>
    <body>
        <h1>Create Account</h1>

        <form action="createAccount.do" method="POST">

            <p>
                <label> Bill  </label>
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
        <c:url value="adminHome.do" var="adminMenu"> </c:url>
        <p><a href="${adminMenu}">Main Menu</a> </p>   


    </form>

</body>
</html>