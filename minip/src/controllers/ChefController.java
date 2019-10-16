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
import entities.ChefReport;
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
		
		if(action.equals("Accept")) {
			int o_id = Integer.parseInt(req.getParameter("o_id"));
			id = Integer.parseInt(req.getParameter("id"));
			System.out.println("\n\n"+o_id);
			chefdoa.acceptOrder(o_id);
			viewOrderRequests(req,resp);
		}
		else if(action.equals("show_profile")) {
			doPost(req,resp);
		}
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
		else if(action.equals("ChefReport")) {
			viewChefReport(request,response);
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
	
	void viewChefReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<ChefReport> list= new ArrayList<ChefReport>();
		list = chefdoa.chefReport(id);
		request.setAttribute("id", id);
		request.setAttribute("count", list.get(0).getCount());
		request.setAttribute("sum", list.get(0).getSum());
		list.remove(0);
		request.setAttribute("report", list);
		request.getRequestDispatcher("ChefReport.jsp").forward(request, response);
	}
}