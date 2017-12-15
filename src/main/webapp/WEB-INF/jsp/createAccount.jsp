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
        <title>Create Account</title>
    </head>
    <body>
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
            <label>&nbsp;</label>
            <input type="submit" value="Create Account">    
        </p>
        <button type="button" name="back" onclick="history.back()">Back</button>
    </form>

</body>
</html>
