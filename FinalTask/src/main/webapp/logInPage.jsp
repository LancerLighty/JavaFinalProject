<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Log In</title>
    </head>
    <body>
        <h2>Log In</h2><br>
        <p>welcome back!</p>
        <form action="log-in">
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