package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doa.DoaImpl;
import doa.DoaInterface;
import entities.DeliveryExecutive;

public class DeliveryExecutiveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
 
	DoaInterface userdoa;
	
    public DeliveryExecutiveController() {
    	userdoa = new DoaImpl();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =(String) request.getAttribute("action");
		int id=(int) request.getAttribute("id");
		
		DeliveryExecutive deliveryexecutive = userdoa.getDeliveryExecutiveProfile(id);
		
		request.setAttribute("deliveryexecutive", deliveryexecutive);
		
		System.out.println("DeliveryExecutive details :-");
		System.out.println("DeliveryExecutive ID :: "+deliveryexecutive.getEmp_id());
		System.out.println("DeliveryExecutive Name ::"+deliveryexecutive.getEmpName() );
		System.out.println("DeliveryExecutive MobileNumber :: "+deliveryexecutive.getEmpMobNo());
		System.out.println("DeliveryExecutive WorkZone :: "+deliveryexecutive.getWorkZone());
		
		if(action.equals("show_profile")) {
			// Forward request to CustomerProfile.jsp
		}
		else if(action.equals("available_orders")) {
			// Forward request to available_orders.jsp
		}
	}
}
