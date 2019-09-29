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
		
		RequestDispatcher dispatcher;
		
		System.out.println("\nLogin details :- "+usertype+"\t"+username+"\t"+password);
		
		int id = userdoa.checkuser(username, password, usertype);
		
		if(id==-1) {
			System.out.println("Login Un-Successful :: "+id);
			dispatcher = request.getRequestDispatcher("Login.html");
		}
		
		else {
			System.out.println("Login successful :: "+id);
			request.setAttribute("id", id);
			request.setAttribute("action", "show_profile");
			dispatcher = request.getRequestDispatcher("CustomerController");
		}
		
		//request.setAttribute("id",id);
		//dispatcher = request.getRequestDispatcher("");
	}
}
