package it.webapp.servlet;


import it.webapp.User;
import it.webapp.UserManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchUser extends HttpServlet {
    UserManager userManager;

    @Override
    public void init() throws ServletException {
        userManager = new UserManager();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User userFound = userManager.getUser(req.getParameter("username"));
       
        Integer id = userManager.getUserId(req.getParameter("username"));
        
        
        RequestDispatcher rd;
        try{
           // User userDetails = userManager.getUserInfo(id);

            if(userFound != null){
                rd = req.getRequestDispatcher("searchUserTrovato.jsp");
                req.setAttribute("username", userFound.getUsername());
                req.setAttribute("nome", userFound.getNome());
                req.setAttribute("cognome", userFound.getCognome());
                req.setAttribute("data_nascita", userFound.getData_nascita());
                req.setAttribute("email", userFound.getEmail());
                req.setAttribute("telefono", userFound.getTelefono());
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
