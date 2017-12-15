<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/main.css">
        <link type="text/css" rel="stylesheet" href="css/smiles.css">
        <title>List All Administrators</title>
    </head>
    <body>
        <main>
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
                    <button type="button" name="back" onclick="history.back()">Back</button>
        </main>
    </body>
</html>
