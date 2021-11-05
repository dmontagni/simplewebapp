<<<<<<< HEAD
package it.webapp.servlet;

import it.webapp.Customer;
import it.webapp.User;
import it.webapp.UserManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Mohamed ed Andrea: tool di ricerca
public class SearchUser extends HttpServlet {
    UserManager userManager;

    @Override
    public void init() throws ServletException {
        userManager = new UserManager();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User userFound = userManager.getUser(req.getParameter("username"));
        RequestDispatcher rd;
        try{
            Customer userDetails = userManager.getUserInfo(userFound.getIdUser());

            if(userDetails != null){
                rd = req.getRequestDispatcher("searchUserTrovato.jsp");
                req.setAttribute("username", userFound.getUsername());
                req.setAttribute("nome", userDetails.getNome());
                req.setAttribute("cognome", userDetails.getCognome());
                req.setAttribute("data_nascita", userDetails.getData_nascita());
                req.setAttribute("email", userDetails.getEmail());
                req.setAttribute("telefono", userDetails.getTelefono());
                rd.forward(req, resp);
            } else {
                rd = req.getRequestDispatcher("searchUserFail.jsp");
                rd.forward(req, resp);
            }
        } catch (Exception e){
            rd = req.getRequestDispatcher("searchUserFail.jsp");
            rd.forward(req, resp);
        }





    }
}

=======
package it.webapp.servlet;

import it.webapp.Customer;
import it.webapp.User;
import it.webapp.UserManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Mohamed ed Andrea: tool di ricerca
public class SearchUser extends HttpServlet {
    UserManager userManager;

    @Override
    public void init() throws ServletException {
        userManager = new UserManager();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User userFound = userManager.getUser(req.getParameter("username"));
        RequestDispatcher rd;
        try{
            Customer userDetails = userManager.getUserInfo(userFound.getIdUser());

            if(userDetails != null){
                rd = req.getRequestDispatcher("searchUserTrovato.jsp");
                req.setAttribute("username", userFound.getUsername());
                req.setAttribute("nome", userDetails.getNome());
                req.setAttribute("cognome", userDetails.getCognome());
                req.setAttribute("data_nascita", userDetails.getData_nascita());
                req.setAttribute("email", userDetails.getEmail());
                req.setAttribute("telefono", userDetails.getTelefono());
                rd.forward(req, resp);
            } else {
                rd = req.getRequestDispatcher("searchUserFail.jsp");
                rd.forward(req, resp);
            }
        } catch (Exception e){
            rd = req.getRequestDispatcher("searchUserFail.jsp");
            rd.forward(req, resp);
        }





    }
}

>>>>>>> branch 'main' of git@github.com:dmontagni/simplewebapp.git
