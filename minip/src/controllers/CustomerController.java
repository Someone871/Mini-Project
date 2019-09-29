package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doa.DoaImpl;
import doa.DoaInterface;
import entities.Customer;

public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DoaInterface userdoa;
	
    public CustomerController() {
    	userdoa = new DoaImpl();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String str_id = request.getParameter("id");
		int id = Integer.parseInt(str_id);
		
		Customer customer = userdoa.getCustomerProfile(id);
		
		request.setAttribute("customer", customer);
		
		System.out.println("Customer details :-");
		System.out.println("Customer ID :: "+customer.getCust_id());
		System.out.println(" Name :: "+customer.getFullname());
		System.out.println(" Address :: "+customer.getAddress());
		System.out.println(" Mobile Number :: "+customer.getMobno());
		System.out.println(" Email - ID :: "+customer.getEmail());
		System.out.println(" Area :: "+customer.getArea());
		
		if(action.equals("show_profile")) {
			// Forward request to CustomerProfile.jsp
		}
		else if(action.equals("order_food")) {
			// Forward request to OrderFood.jsp
		}
	}
}
