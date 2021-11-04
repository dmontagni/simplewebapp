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
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InsertUserDetails extends HttpServlet {
    UserManager userManager;

    @Override
    public void init() throws ServletException {
        userManager = new UserManager();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        User user;
        user = userManager.getUser(req.getParameter("username"));

        Customer userToSave = new Customer(req.getParameter("nome"), req.getParameter("cognome"),
                Date.valueOf(LocalDate.parse(req.getParameter("data_nascita"),format)),
                req.getParameter("email"),req.getParameter("email"),user.getIdUser());
        System.out.println(userToSave);
        boolean userSaved = userManager.saveUserDetails(userToSave);

        RequestDispatcher rd;
        if(userSaved){
            rd = req.getRequestDispatcher("saveUserSuccess.jsp");
            req.setAttribute("username", user.getUsername());
        } else {
            rd = req.getRequestDispatcher("saveUserFail.jsp");
        }
        rd.forward(req, resp);


    }
}
