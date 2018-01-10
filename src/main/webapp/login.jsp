<%-- 
    Document   : login
    Created on : 12-Dec-2017, 2:21:35 PM
    Author     : reliq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="WEB_INF/css/main.css
          <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue.css">
          <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <head>

        <title>Login</title>
    </head>
    <body>

        <div class="w3-top">
            <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
                <a href="#" class="w3-bar-item w3-theme-l1"><img src="sheridanBank_logo.png" height="40" width="40" alt="Logo"></a>
            </div>
        </div>

        <div class="w3-main" style="margin-left:250px">

            <div class="w3-row w3-padding-64">
                <div class="w3-twothird w3-container">
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
                </div>
            </div>
        </div>
    </body>
</html>
