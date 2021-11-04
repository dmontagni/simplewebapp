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

        Customer userDetails = userManager.getUserInfo(userFound.getIdUser());

        RequestDispatcher rd;
        if(userDetails != null){
            rd = req.getRequestDispatcher("searchUserSuccess.jsp");
            req.setAttribute("nome", userDetails.getNome());
            req.setAttribute("cognome", userDetails.getCognome());
            req.setAttribute("data_nascita", userDetails.getData_nascita());
            req.setAttribute("email", userDetails.getEmail());
            req.setAttribute("telefono", userDetails.getTelefono());
        } else {
            rd = req.getRequestDispatcher("searchUserFail.jsp");
        }
        rd.forward(req, resp);


    }
}

