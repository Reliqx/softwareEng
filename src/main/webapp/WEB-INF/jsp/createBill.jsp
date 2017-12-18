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
        <title>Create Bill</title>
    </head>
    <body>
        <h1>Create Bill</h1>

        <form action="createBill.do" method="POST">

            <p>
                <label> Bill ID </label>
                <input type="text" maxlength='15' size='15' name="billID" required/>
            </p>

            <p>
                <label> Account ID </label>
                <input type="text" maxlength='15' size='15' name="accountID" required/>
            </p>

            <p>
                <label> Amount </label>
                <input type="text" maxlength='45' size='45' name="amount" required/>
            </p>        
            <p>
                <label>&nbsp;</label>
                <input type="submit" value="Create Bill">    
            </p>
            <c:url value="adminHome.do" var="adminMenu"> </c:url>
            <p><a href="${adminMenu}">Main Menu</a> </p>   


        </form>

    </body>
</html>