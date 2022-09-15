<%--
  Created by IntelliJ IDEA.
  User: tekla
  Date: 9/12/2022
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>SignUp page</title>
    </head>
    <body>
        <h2>Welcome</h2>
        <form action="Sign-Up">
            <h5 style="color:#b41e1e;">Username Can't have @ this symbol</h5><br>
            <label for="id">Set Id: </label><br>
            <input type="text" id="id"  name="id" placeholder="Id" required><br>
            <label for="name">Set Name:</label><br>
            <input type="text" id="name" name="name" placeholder="Name" required><br>
            <label for="surname">Set Surname: </label><br>
            <input type="text" id="surname"  name="surname" placeholder="Surname" required><br>
            <label for="username">Set Username: </label><br>
            <input type="text" id="username"  name="username" placeholder="Username" required><br>
            <label for="Email">Set Email: </label><br>
            <input type="text" id="Email"  name="Email" placeholder="Email" required><br>
            <label for="password">Password: </label><br>
            <input type="password" id="password"  name="password" placeholder="Password" required><br>
            <label for="repeatPass">repeat Password: </label><br>
            <input type="password" id="repeatPass"  name="repeatPass" placeholder="Password" required><br>
            <label for="profession">Set Profession: </label><br>
            <input type="text" id="profession"  name="profession" placeholder="Profession"><br>
            <input Type="submit" value="Sign up"><br>
        </form>
        <p>Already have an account?</p>
        <a href=logInPage.jsp>LogIn</a>
    </body>
</html>
