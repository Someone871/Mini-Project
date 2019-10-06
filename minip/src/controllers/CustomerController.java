package controllers;

import java.io.IOException;
import java.util.List;

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
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	// Forward to doPost
    	doPost(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = null;
		int id = -1;
		try {
			// 
			action = (String) request.getAttribute("action");
			id = (int) request.getAttribute("id");
		}
		catch(Exception e) {
			action = request.getParameter("action");
			id = Integer.parseInt(request.getParameter("id"));
		}
		
		System.out.println("In Customer Controller Servlet\t"+id);
		
		//RequestDispatcher dispatcher=null;
		
		System.out.println("Action :: "+action);
		
		if(action.equals("order_food")) {
			// Forward request to OrderFood.jsp
			List <Chef> list = userdoa.getPotentialOrders(id);
			request.setAttribute("id", id);
			System.out.println("Dispatching to OrderFood.jsp");
			request.setAttribute("list", list);
			request.getRequestDispatcher("OrderFood.jsp").forward(request, response);;
		}
		else if(action.equals("show_profile")){
			// Forward request to CustomerProfile.jsp
			
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
			System.out.println("Dispatching to CustomerProfile.jsp");
			request.getRequestDispatcher("CustomerProfile.jsp").forward(request, response);;
		}
		else {
			// Action = AddOrder
			// Forward request to ConfirmOrder.jsp
			/* Attributes Received :-
			 * id, chef_id, TiffinDesc, UnitCost, NumAvl 
			 * */
			int chef_id = Integer.parseInt(request.getParameter("chef_id"));
			String TiffinDesc = request.getParameter("TiffinDesc");
			int UnitCost = Integer.parseInt(request.getParameter("UnitCost"));
			int NumAvl = Integer.parseInt(request.getParameter("NumAvl"));
			
			System.out.println("AddOrder Attributes Received :-\nCustomer ID :: "+id+"Chef_id :: "+chef_id
					+"\nTiffin Desc"+TiffinDesc+"Unit Cost :: "+UnitCost+"NumAvl"+NumAvl);
			
			System.out.println("\nForwarding to ConfirmOrder.jsp");
			
			request.setAttribute("cust_id", id);
			request.setAttribute("chef_id", chef_id);
			//request.getRequestDispatcher("ConfirmOrder.jsp").forward(request, response);
			
		}
	}
}
