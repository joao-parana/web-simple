package com.example.servlets.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.servlets.User;

@WebServlet("/log_in")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = '" + username + "'");
        System.out.println("password = '" + password + "'");

        try {
            request.login(username, password);
            HttpSession session = request.getSession();
            User myUser = new User(username);
            // Verificar roles do usuário autenticado
            if (request.isUserInRole("user")) {
                myUser.addRole("user");
            }
            if (request.isUserInRole("manager-jmx")) {
                myUser.addRole("manager-jmx");
            }

            session.setAttribute("user", myUser);
            System.out.println("Attribute user set in session. User = '" + myUser + "'");
            response.sendRedirect("home.html");
        } catch (ServletException e) {
            e.printStackTrace();
            response.sendRedirect("login.html?error=true");
        }
    }
}
