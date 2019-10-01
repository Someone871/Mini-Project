package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doa.DoaImpl;
import doa.DoaInterface;

public class LoginContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DoaInterface userdoa;
	
    public LoginContoller() {
    	userdoa = new DoaImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usertype = request.getParameter("usertype");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String action = "";
		
		RequestDispatcher dispatcher;
		
		System.out.println("\nLogin details :- "+usertype+"\t"+username+"\t"+password);
		
		int id = userdoa.checkuser(username, password, usertype);
		if(id==-1) {
			System.out.println("Login Un-Successful :: "+id);
			dispatcher = request.getRequestDispatcher("Login.html");
		}
		else {
			if(usertype.equals("cust")){
				System.out.println("Customer Login successful :: "+id);
				request.setAttribute("id", id);
				action = "show_profile";
				request.setAttribute("action", action);
				
				dispatcher = request.getRequestDispatcher("CustomerController");
				
				dispatcher.forward(request, response);
			}
			else if (usertype.equals("chef")) {
				System.out.println("Chef Login successful :: "+id);
				request.setAttribute("id", id);
				action = "show_profile";
				request.setAttribute("action", action);
				
				dispatcher = request.getRequestDispatcher("ChefController");
				
				dispatcher.forward(request, response);
			}
			else {
				System.out.println("Delivery Executive Login successful :: "+id);
				request.setAttribute("id", id);
				action = "show_profile";
				request.setAttribute("action", action);
				
				dispatcher = request.getRequestDispatcher("DeliveryExecutiveController");
				
				dispatcher.forward(request, response);
			}
		}
		
		//request.setAttribute("id",id);
		//dispatcher = request.getRequestDispatcher("");
	}
}
