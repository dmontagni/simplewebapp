package it.webapp.servlet;


import it.webapp.Customer;
import it.webapp.User;
import it.webapp.DeleteUserManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteServlet extends HttpServlet {
    DeleteUserManager userManager;

    @Override
    public void init() throws ServletException {
        userManager = new DeleteUserManager();
    }

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd;
        String cerca = req.getParameter("cerca");
        if(cerca != null && userManager.validate(cerca)) {
		User alist = userManager.getUser(cerca);
        rd = req.getRequestDispatcher("userlistSingolo.jsp");
        req.setAttribute("usersList", alist);
        rd.forward(req, resp);
			}else {
				System.out.println("non ho trovato nessuno");
	    		resp.sendRedirect("/simplewebapp/error.jsp");
			}
        
    }
 



	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("delete");
		RequestDispatcher rd;
		System.out.println(username);
		if(username!= null && userManager.validate(username)) {
			
	    		Integer id = userManager.getUserId(username);
	    		userManager.deleteUser(id);
	    		resp.sendRedirect("/simplewebapp/deleteSuccess.jsp");
	    		
	    	}else {
	    		resp.sendRedirect("/simplewebapp/error.jsp");
	    		System.out.println("Non posso cancellare utenti non presenti nel database");
	    	}
		}
		
		
    	

    }




	
