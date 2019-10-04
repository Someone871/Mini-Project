package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doa.DoaImpl;
import doa.DoaInterface;
import entities.Chef;
import entities.Customer;

public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DoaInterface userdoa;
	
    public CustomerController() {
    	userdoa = new DoaImpl();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = (String) request.getAttribute("action");
		int id = (int) request.getAttribute("id");
		
		System.out.println("In Servlet\t"+id);
		
		// Get customer profile and save in Customer object
		Customer customer = userdoa.getCustomerProfile(id);
		
		// Set customer object as attribute of request
		request.setAttribute("customer", customer);
		
		// Print customer details
		System.out.println("Customer details :-");
		System.out.println("Customer ID :: "+customer.getCust_id());
		System.out.println(" Name :: "+customer.getFullname());
		System.out.println(" Address :: "+customer.getAddress());
		System.out.println(" Mobile Number :: "+customer.getMobno());
		System.out.println(" Email - ID :: "+customer.getEmail());
		System.out.println(" Area :: "+customer.getArea());
		
		RequestDispatcher dispatcher;
		
		if(action.equals("show_profile")) {
			// Forward request to CustomerProfile.jsp
			dispatcher = request.getRequestDispatcher("CustomerProfile.jsp");
			//dispatcher.forward(request, response);
		}
		else if(action.equals("order_food")) {
			// Forward request to OrderFood.jsp
			List <Chef> list = userdoa.getPotentialOrders(id);
			dispatcher = request.getRequestDispatcher("OrderFood.jsp");
			//dispatcher.forward(request, response);
		}
	}
}
