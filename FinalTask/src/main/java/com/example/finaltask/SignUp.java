package com.example.finaltask;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Sign-Up", value = "/Sign-Up")
public class SignUp extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repeatPass = request.getParameter("repeatPass");
        String profession = request.getParameter("profession");
        if(profession == null || profession == "required")
            profession = "none";
        MySQL mysql = new MySQL();
        try {
        if(!password.equals((repeatPass))) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("PasswordsNotSame.jsp");
            dispatcher.forward(request, response);
        } else if (mysql.findInfo("email", email, "email") != null || !(mysql.findInfo("username", username, "username") == null)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("AlreadyExists.jsp");
            dispatcher.forward(request, response);
        } else if (usernameSymbolCheck(username)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("UsernameSymbolError.jsp");
            dispatcher.forward(request, response);
        } else {
            UserClass newUser = new UserClass();
            newUser.setAllInfo(newUser, id, name, surname, username, email, password, profession);
            mysql.insertInfo(newUser.getId(), newUser.getName(), newUser.getSurname(), newUser.getUsername(), newUser.getEmail(), newUser.getPassword(), newUser.getProfession());
            setOnPage(newUser, request, response);
        }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher  dispatcher = request.getRequestDispatcher("UserPage.jsp");
        dispatcher.forward(request, response);
    }


    private static void setOnPage(UserClass newUser, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        request.setAttribute("id", newUser.getId());
        request.setAttribute("name", newUser.getName());
        request.setAttribute("surname", newUser.getSurname());
        request.setAttribute("username", newUser.getUsername());
        request.setAttribute("email", newUser.getEmail());
        request.setAttribute("password", newUser.getPassword());
        request.setAttribute("profession", newUser.getProfession());
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserPage.jsp");
        dispatcher.forward(request, response);
    }

    private static boolean usernameSymbolCheck(String a) {
        for(Character letter: a.toCharArray())
            if(letter.equals('@'))
                return true;
        return false;
    }
}
