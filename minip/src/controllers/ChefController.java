package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doa.DoaImpl;
import doa.DoaInterface;
import entities.Chef;

/**
 * Servlet implementation class ChefController
 */
public class ChefController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    DoaInterface chefdoa;
	
    public ChefController() {
        chefdoa = new DoaImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = (String) request.getAttribute("action");
		if(action == null)
			action = request.getParameter("action");
		
		if(action.equals("show_profile")) {
			
			int id = (int) request.getAttribute("id");
			Chef chef = chefdoa.getChefProfile(id);
			
			request.setAttribute("chef", chef);
			
			System.out.println("Chef details :-");
			System.out.println("Chef ID :: "+chef.getChef_id());
			System.out.println(" Name :: "+chef.getName());
			System.out.println(" Address :: "+chef.getAddress());
			System.out.println(" Mobile Number :: "+chef.getMobno());
			
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
		}
	}

}
