package it.webapp.servlet;


import it.webapp.User;
import it.webapp.UserManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat format2 = new SimpleDateFormat();
        //java.util.Date data = new java.util.Date(format.format(req.getParameter("data_nascita")));
        User user = userManager.getUser(req.getParameter("username"));
        
        boolean userSaved = userManager.updateUser(userManager.getUserId(req.getParameter("username")),req.getParameter("nome"),req.getParameter("cognome"),
        Date.valueOf(LocalDate.parse(req.getParameter("data_nascita"),format).plusDays(1)),req.getParameter("telefono"),req.getParameter("email"));



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