<%--
  Created by IntelliJ IDEA.
  User: tekla
  Date: 9/6/2022
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
    <title>User Page</title>
    </head>
    <body>
            <h2>Welcome <%=request.getAttribute("username")%></h2>
            <p>Id: <%=request.getAttribute("id")%></p>
            <p>Name: <%=request.getAttribute("name")%></p>
            <p>Surname: <%=request.getAttribute("surname")%></p>
            <p>Username: <%=request.getAttribute("username")%></p>
            <p>Email: <%=request.getAttribute("email")%></p>
            <p>Password: <%=request.getAttribute("password")%></p>
            <p>Profession: <%=request.getAttribute("profession")%></p>
            <a href="index.jsp">
                <button>Sign Out</button>
            </a>
    </body>
</html>
