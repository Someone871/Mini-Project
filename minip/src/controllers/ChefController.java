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
		
		String action = req.getParameter("action");
		int o_id = Integer.parseInt(req.getParameter("o_id"));
		id = Integer.parseInt(req.getParameter("id"));
		System.out.println("\n\n"+o_id);
		if(action.equals("Accept")) {
			chefdoa.acceptOrder(o_id);
			viewOrderRequests(req,resp);
		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = (String) request.getAttribute("action");
		if(action == null)
			action = request.getParameter("action");
		
		if(action.equals("show_profile")) {
			 try {
				 id = (int) request.getAttribute("id");
			 }catch(Exception e) {
				 id = Integer.parseInt(request.getParameter("id"));
			 }
			Chef chef = chefdoa.getChefProfile(id);
			
			request.setAttribute("chef", chef);
			// Forward request to ChefProfile.jsp
			request.setAttribute("Chef_id",chef.getChef_id());
			request.setAttribute("Name",chef.getName());
			request.setAttribute("Address",chef.getAddress());
			request.setAttribute("Mobno",chef.getMobno());
			
			request.getRequestDispatcher("ChefProfile.jsp").forward(request, response);
		}
		else if(action.equals("set_menu")) {
			System.out.println(action);
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
		else if(action.equals("ViewOrderRequests")) {
			
			//int id = Integer.parseInt(request.getParameter("id"));
			/*List<Order> orders = new ArrayList<Order>();
			orders = chefdoa.getPendingOrders(id);
			request.setAttribute("id", id);
			request.setAttribute("orders", orders);
			request.getRequestDispatcher("PendingOrders.jsp").forward(request, response);*/
			viewOrderRequests(request,response);
		}
		else if(action.equals("ViewAcceptedOrders")) {
			List<Order> orders = new ArrayList<Order>();
			orders = chefdoa.getAcceptedOrders(id);
			request.setAttribute("id", id);
			request.setAttribute("orders", orders);
			request.getRequestDispatcher("AcceptedOrders.jsp").forward(request, response);
		}
	}
	
	void viewOrderRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Order> orders = new ArrayList<Order>();
		orders = chefdoa.getPendingOrders(id);
		request.setAttribute("id", id);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("PendingOrders.jsp").forward(request, response);
	}
}