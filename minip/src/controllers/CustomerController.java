package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import doa.DoaImpl;
import doa.DoaInterface;
import entities.Chef;
import entities.Customer;
import entities.Order;

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
		HttpSession session = request.getSession(false);
		if(session==null) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("Please Login First");
			request.getRequestDispatcher("Login.html").include(request, response);
			out.close();
		}
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
		//*----------------------------- SHOW AVAILABLE ORDERS ----------------------------*//
		if(action.equals("order_food")) {
			// Get list of chefs the customer can order from
			String cuisine = request.getParameter("cuisine");
			List <Chef> list = new ArrayList<Chef>();
			if(cuisine==null) {
				list = userdoa.getPotentialOrders(id);
			}
			else {
				list = userdoa.getPotentialOrders(id,cuisine);
			}
			// Set 'id' and 'list' attribute
			request.setAttribute("id", id);
			request.setAttribute("list", list);
			System.out.println("Dispatching to OrderFood.jsp");
			// Forward request to OrderFood.jsp
			request.getRequestDispatcher("OrderFood.jsp").forward(request, response);;
		}
		//*---------------------------- SHOW CUSTOMER PROFILE ----------------------------*//
		else if(action.equals("show_profile")){
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
			
			request.setAttribute("id", id);
			
			// Forward request to CustomerProfile.jsp
			request.getRequestDispatcher("CustomerProfile.jsp").forward(request, response);
		}
		//*--------------------- SELECT ONE ORDER FROM AVAILABLE ---------------------*//
		else if(action.equals("AddOrder")) {
			// Action = AddOrder
			// Attributes Received :-
			// id, chef_id, TiffinDesc, UnitCost, NumAvl 
			
			int chef_id = Integer.parseInt(request.getParameter("chef_id"));
			String TiffinDesc = request.getParameter("TiffinDesc");
			int UnitCost = Integer.parseInt(request.getParameter("UnitCost"));
			int NumAvl = Integer.parseInt(request.getParameter("NumAvl"));
			
			System.out.println("AddOrder Attributes Received :-\nCustomer ID :: "+id+"Chef_id :: "+chef_id
					+"\nTiffin Desc"+TiffinDesc+"Unit Cost :: "+UnitCost+"NumAvl"+NumAvl);
			
			System.out.println("\nForwarding to ConfirmOrder.jsp");
			
			request.setAttribute("id", id);
			request.setAttribute("chef_id", chef_id);
			request.setAttribute("TiffinDesc", TiffinDesc);
			request.setAttribute("UnitCost", UnitCost);
			request.setAttribute("NumAvl", NumAvl);
			
			// Forward request to ConfirmOrder.jsp
			request.getRequestDispatcher("ConfirmOrder.jsp").forward(request, response);
		}
		//*----------------------- CONFIRM SELECTED ORDER ------------------------*//
		else if(action.equals("ConfirmOrder")){
			// action = ConfirmOrder
			// Attributes Received :- 
			// id , chef_id, NumOrdered, UnitCost
			
			int chef_id = Integer.parseInt(request.getParameter("chef_id"));
			int UnitCost = Integer.parseInt(request.getParameter("UnitCost"));
			int NumOrdered = Integer.parseInt(request.getParameter("NumOrdered"));
			int total_cost = UnitCost * NumOrdered;
			
			int order_id = userdoa.insertOrder(id, chef_id, NumOrdered, total_cost);
			
			System.out.println("Order ID :: "+order_id);
			
			request.setAttribute("action","show_current_orders");
			request.setAttribute("id",id);
			request.getRequestDispatcher("CustomerController").forward(request, response);
		}
		//*----------------- SHOW CURRENT ORDERS --------------------*//
		else if(action.equals("show_current_orders")) {
			List<Order> list = userdoa.getCurrentOrders(id);
			request.setAttribute("list", list);
			request.setAttribute("id", id);
			
			request.getRequestDispatcher("CurrentOrders.jsp").forward(request, response);
		}
		//*--------------------- CANCEL ORDER -----------------------*//
		else if (action.equals("cancel_order")) {
			
			int order_id = Integer.parseInt(request.getParameter("order_id"));
			int emp_id = Integer.parseInt(request.getParameter("emp_id"));
			int chef_id = Integer.parseInt(request.getParameter("chef_id"));
			int NumOrdered = Integer.parseInt(request.getParameter("NumOrdered"));
			
			System.out.println(order_id);
			System.out.println(emp_id);
			System.out.println(chef_id);
			System.out.println(NumOrdered);
			
			int err=userdoa.cancelOrder(order_id, emp_id, chef_id, NumOrdered);
			System.out.println("Cancel Order Returned :: "+err);
			
			List<Order> list = userdoa.getCurrentOrders(id);
			request.setAttribute("list", list);
			request.setAttribute("id", id);
			request.getRequestDispatcher("CurrentOrders.jsp").forward(request, response);
		}
		//*--------------------- RATE ORDER -----------------------*//
		else if(action.equals("rate_chef_emp")) {
			int order_id = Integer.parseInt(request.getParameter("order_id"));
			int emp_id = Integer.parseInt(request.getParameter("emp_id"));
			int chef_id = Integer.parseInt(request.getParameter("chef_id"));
			int chef_rating = Integer.parseInt(request.getParameter("chef_rating"));
			int del_rating = Integer.parseInt(request.getParameter("del_rating"));
			
			System.out.println("--------------- Rating  ---------------");
			System.out.println(order_id);
			System.out.println(emp_id);
			System.out.println(chef_id);
			System.out.println(chef_rating);
			System.out.println(del_rating);
			
			userdoa.rateOrder(order_id, chef_id, emp_id, chef_rating, del_rating);
			
			request.setAttribute("id", id);
			request.setAttribute("action","show_current_orders");
			
			request.getRequestDispatcher("CustomerController").forward(request, response);
		}
		//*--------------------- ORDER HISTORY -----------------------*//
		else if(action.equals("show_order_history")) {
			List<Order> list = userdoa.getCustomerOrderHistory(id);
			request.setAttribute("list", list);
			request.setAttribute("id", id);
			
			request.getRequestDispatcher("CustomerOrderHistory.jsp").forward(request, response);
		}
		else if(action.equals("go_to_rateOrder")) {
			request.setAttribute("id", id);
			request.setAttribute("order_id", request.getParameter("order_id"));
			request.setAttribute("chef_name", request.getParameter("chef_name"));
			request.setAttribute("chef_id", request.getParameter("chef_id"));
			request.setAttribute("emp_id", request.getParameter("emp_id"));
			request.setAttribute("emp_id", request.getParameter("emp_id"));
			request.getRequestDispatcher("RateOrder.jsp").forward(request, response);
		}
	}
}
