package it.webapp.servlet;

import it.webapp.User;
import it.webapp.UserManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertUser extends HttpServlet {
    UserManager userManager;

    @Override
    public void init() throws ServletException {
        userManager = new UserManager();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User userToSave = new User(req.getParameter("username"), req.getParameter("password"));

        boolean userSaved = userManager.saveUser(userToSave);

        RequestDispatcher rd;
        if(userSaved){
            rd = req.getRequestDispatcher("index.jsp");
            //req.setAttribute("username", userToSave.getUsername());
        } else {
            rd = req.getRequestDispatcher("saveUserFail.jsp");
        }
        rd.forward(req, resp);


    }
}