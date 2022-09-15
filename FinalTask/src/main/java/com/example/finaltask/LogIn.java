package com.example.finaltask;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;

@WebServlet(name = "log-in", value = "/log-in")
public class LogIn extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String usernameEmail = request.getParameter("UsernameEmail");
        String password = request.getParameter("password");
        MySQL findInfo = new MySQL();
        try {
        if(emailCheck(usernameEmail)) {
            if(!password.equals(findInfo.findInfo("email", usernameEmail, "password")) || findInfo.findInfo("email", usernameEmail, "email") == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("IncorrectLogIn.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("id", findInfo.findInfo("email", usernameEmail, "id"));
                request.setAttribute("name", findInfo.findInfo("email", usernameEmail, "name"));
                request.setAttribute("surname", findInfo.findInfo("email", usernameEmail, "surname"));
                request.setAttribute("username", findInfo.findInfo("email", usernameEmail, "username"));
                request.setAttribute("email", usernameEmail);
                request.setAttribute("password", findInfo.findInfo("email", usernameEmail, "password"));
                request.setAttribute("profession", findInfo.findInfo("email", usernameEmail, "profession"));
                RequestDispatcher dispatcher = request.getRequestDispatcher("UserPage.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            if(!password.equals(findInfo.findInfo("username", usernameEmail, "password")) || findInfo.findInfo("username", usernameEmail, "username") == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("IncorrectLogIn.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("id", findInfo.findInfo("username", usernameEmail, "id"));
                request.setAttribute("name", findInfo.findInfo("username", usernameEmail, "name"));
                request.setAttribute("surname", findInfo.findInfo("username", usernameEmail, "surname"));
                request.setAttribute("username", usernameEmail);
                request.setAttribute("email", findInfo.findInfo("username", usernameEmail, "email"));
                request.setAttribute("password", findInfo.findInfo("username", usernameEmail, "password"));
                request.setAttribute("profession", findInfo.findInfo("username", usernameEmail, "profession"));
                RequestDispatcher dispatcher = request.getRequestDispatcher("UserPage.jsp");
                dispatcher.forward(request, response);
            }
        }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean emailCheck(String a) {
        for(Character letter: a.toCharArray())
            if(letter.equals('@'))
                return true;
        return false;
    }
}