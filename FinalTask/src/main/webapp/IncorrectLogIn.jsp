<%--
  Created by IntelliJ IDEA.
  User: tekla
  Date: 9/12/2022
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
</head>
<body>
<h2>Log In</h2><br>
<form action="log-in">
    <h5 style="color:#b41e1e;">incorrect Password or Username/Email.</h5>
    <label for="UsernameEmail">Enter your Username or Email:</label><br>
    <input type="text" id="UsernameEmail"  name="UsernameEmail" placeholder="Username or Email" required><br>
    <label for="password">Enter your Password:</label><br>
    <input type="password" id="password" name="password" placeholder="Password" required><br><br>
    <input Type="submit" value="LogIn">
</form>
<p>Don't have an account?</p>
<a href=SignUpPage.jsp>Register</a>
</body>
</html>
