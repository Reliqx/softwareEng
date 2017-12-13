<%-- 
    Document   : login
    Created on : 12-Dec-2017, 2:21:35 PM
    Author     : reliq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login!</h1>

        <form action="login.do" method="POST">

            <p>
                <label> Login </label>
                <input type="text" maxlength='15' size='15' name="user" required/>
            </p>

            <p>
                <label> Password </label>
                <input type="password" maxlength='15' size='15' name="pass" required/>
            </p>
            <p>
                <label>&nbsp;</label>
                <input type="submit" value="Login">    
            </p>
        </form>
    </body>
</html>
