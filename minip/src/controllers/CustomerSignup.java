package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doa.DoaImpl;
import doa.DoaInterface;
import entities.Customer;

public class CustomerSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DoaInterface userdoa;
	
    public CustomerSignup() {
        userdoa = new DoaImpl();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String address = request.getParameter("address");
		String area = request.getParameter("area");
		String mobno = request.getParameter("mobno");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Customer customer = new Customer();
		customer.setFullname(fullname);
		customer.setAddress(address);
		customer.setArea(area);
		customer.setMobno(mobno);
		customer.setEmail(email);
		
		System.out.println("Received Details :-");
		System.out.println(fullname);
		System.out.println(address);
		System.out.println(area);
		System.out.println(mobno);
		System.out.println(email);
		System.out.println(username);
		System.out.println(password);
		
		
		userdoa.addCustomer(customer, username, password);
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
		//dispatcher.forward(request, response);
		
	}

}
