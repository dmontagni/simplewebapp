package it.webapp.servlet;

import it.webapp.User;
import it.webapp.UserManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    UserManager userManager;

    @Override
    public void init() throws ServletException {
        userManager = new UserManager();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userManager.getUser(username);
        System.out.println(user);
        RequestDispatcher rd;
        if(user != null && (user.getUsername().equals(username) && user.getPassword().equals(password))){
            rd = req.getRequestDispatcher("result.jsp");
            req.setAttribute("username", username);
        } else {
            rd = req.getRequestDispatcher("error.jsp");
        }
        rd.forward(req, resp);
    }





}