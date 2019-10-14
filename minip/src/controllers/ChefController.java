package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doa.DoaImpl;
import doa.DoaInterface;
import entities.Chef;
import entities.Order;

/**
 * Servlet implementation class ChefController
 */
public class ChefController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    DoaInterface chefdoa;
    int id;
	
    public ChefController() {
        chefdoa = new DoaImpl();
    }
    
    
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req,resp);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = (String) request.getAttribute("action");
		if(action == null)
			action = request.getParameter("action");
		
		if(action.equals("show_profile")) {
			 showProfile(request,response);
		}
		else if(action.equals("set_menu")) {
			setMenu(request,response);
		}
		else if(action.equals("ViewOrderRequests")) {
			viewOrderRequests(request,response);
		}
		else if(action.equals("ViewAcceptedOrders")) {
			viewAcceptedOrders(request,response);
		}
		else if(action.equals("Accept")) {
			acceptOrder(request,response);
		}
		
	}
	
	void showProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			 id = (int) request.getAttribute("id");
		 }catch(Exception e) {
			 id = Integer.parseInt(request.getParameter("id"));
		 }
		Chef chef = chefdoa.getChefProfile(id);
		
		request.setAttribute("chef", chef);
		request.setAttribute("Chef_id",chef.getChef_id());
		
		request.getRequestDispatcher("ChefProfile.jsp").forward(request, response);
	}
	
	void setMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(request.getParameter("id"));
		Chef chef = chefdoa.getChefProfile(id);
		
		chef.setCuisine(request.getParameter("cuisine"));
		chef.setNumAvl(Integer.parseInt(request.getParameter("num_avl")));
		chef.setTiffinDesc(request.getParameter("tiff_desc"));
		chef.setUnitCost(Integer.parseInt(request.getParameter("unit_cost")));
		
		chefdoa.updateMenu(chef);
		
		request.setAttribute("id", id);
		request.setAttribute("action", "show_profile");
		request.getRequestDispatcher("ChefController").forward(request, response);
	}
	
	void viewOrderRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Order> orders = new ArrayList<Order>();
		orders = chefdoa.getPendingOrders(id);
		request.setAttribute("id", id);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("PendingOrders.jsp").forward(request, response);
	}
	
	void viewAcceptedOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Order> orders = new ArrayList<Order>();
		orders = chefdoa.getAcceptedOrders(id);
		request.setAttribute("id", id);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("AcceptedOrders.jsp").forward(request, response);
	}
	
	void acceptOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int o_id = Integer.parseInt(request.getParameter("o_id"));
		id = Integer.parseInt(request.getParameter("id"));
		System.out.println("\n\n"+o_id);
		chefdoa.acceptOrder(o_id);
		viewOrderRequests(request,response);
	}
}