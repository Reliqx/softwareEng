<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
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
        <title>List All Administrators</title>
    </head>
    <body>
        <main>
            <div class="w3-main" style="margin-left:250px">

                <div class="w3-row w3-padding-64">
                    <div class="w3-twothird w3-container">
                        <c:choose>
                            <c:when test="${not empty visits}">
                                <table>
                                    <tr>
                                        <th>User ID</th>
                                        <th>Username</th>
                                    </tr>
                                    <c:forEach items="${visits}" var="v" varStatus="s">
                                        <tr>
                                            <td>${v.user_id}</td>
                                            <td>${v.username}</td>
                                            <td>${v.role}</td>
                                            <td>${v.email}</td>
                                            <td>${v.address}</td>
                                            <td>${v.city}</td>
                                            <td>${v.province}</td>
                                            <td>${v.postalCode}</td>
                                            <td>${v.phoneNumber}</td>

                                            <c:url value="deleteAccount.do" var="ref_delete">
                                                <c:param name="user_id" value="${v.user_id}"/>
                                            </c:url>
                                            <td><a href="${ref_delete}">Delete</a></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </c:when>
                            <c:otherwise>
                                <p class="message">Nobody registered yet.</p>
                            </c:otherwise>
                        </c:choose>
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
        </main>
    </body>
</html>