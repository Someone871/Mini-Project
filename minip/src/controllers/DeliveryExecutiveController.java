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
import entities.ChefCustomer;
import entities.DeliveryExecutive;

public class DeliveryExecutiveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher;     
 
	int id;
	DoaInterface userdoa;
	
    public DeliveryExecutiveController() {
    	userdoa = new DoaImpl();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		request.setAttribute("message", "Saved successfully");

		
		String action;
		

		
		try {
			
			 id=(int) request.getAttribute("id");	
			 action =(String) request.getAttribute("action");
						
			
		}catch(Exception ex)
		{
			id=Integer.parseInt(request.getParameter("id"));
			action=request.getParameter("orders");	
			
		}

		
		
		if(action.equals("show_profile")) {
			// Forward request to CustomerProfile.jsp
			DeliveryExecutive deliveryexecutive = userdoa.getDeliveryExecutiveProfile(id);
			request.setAttribute("deliveryexecutive", deliveryexecutive);
			
			
			System.out.println("DeliveryExecutive details :-");
			System.out.println("DeliveryExecutive ID :: "+deliveryexecutive.getEmp_id());
			System.out.println("DeliveryExecutive Name ::"+deliveryexecutive.getEmpName() );
			System.out.println("DeliveryExecutive MobileNumber :: "+deliveryexecutive.getEmpMobNo());
			System.out.println("DeliveryExecutive WorkZone :: "+deliveryexecutive.getWorkZone());
			
			// Forward request to DeliveryExecutive.jsp
			request.setAttribute("Emp_id",deliveryexecutive.getEmp_id());
			request.setAttribute("EmpName",deliveryexecutive.getEmpName());
			request.setAttribute("EmpMobNo",deliveryexecutive.getEmpMobNo());
			request.setAttribute("WorkZone",deliveryexecutive.getWorkZone());
			
			//request.getRequestDispatcher("DeliveryExecutive.jsp").forward(request, response);
			
	    	dispatcher=request.getRequestDispatcher("DeliveryExecutive.jsp");
	    	dispatcher.forward(request,response);

		
			
			
		}
		else if(action.equals("available_orders")) {
			// Forward request to available_orders.jsp
			
				List<ChefCustomer> list=userdoa.getOrderInfo(id);
		   		request.setAttribute("List",list);  		
		   		dispatcher=request.getRequestDispatcher("DisplayOrderDetails.jsp"); 
	   	   		dispatcher.forward(request,response);
		
			
		} 
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int OrderId=Integer.parseInt(request.getParameter("id"));   //get order_id from the jsp
		String status=request.getParameter("status");             //get status from the jsp
		String action=request.getParameter("action");
		int id=Integer.parseInt(request.getParameter("EmpId"));
		
		
		System.out.println(OrderId);
		System.out.println(status);
		
		if(status.charAt(0)=='C')   //update the status cooking(C) to picked up(D)
		{
			userdoa.changeStatus(OrderId, status);
			if(action.equals("LIST"))
			{
				//dispatch the request to listorderinfo.jsp
				request.setAttribute("message","Order picked up successfully");
				listOrderInfo(request,response,id);
			}
						
			
		}
		
		
		else 						//update the status picked up(D) to delivered(Z)
		{
			userdoa.changeStatus(OrderId, status);
			if(action.equals("LIST"))
			{
				//dispatch the request to listorderinfo.jsp
				request.setAttribute("message","Order Delivered successfully");
				listOrderInfo(request,response,id);
			}
			
		}
		
	}
	
	
	public  void listOrderInfo (HttpServletRequest request, HttpServletResponse response,int id) throws ServletException, IOException
	{
		
		List<ChefCustomer> list=userdoa.getOrderInfo(id);
   		request.setAttribute("List",list);
   		dispatcher=request.getRequestDispatcher("DisplayOrderDetails.jsp"); 
	   	dispatcher.forward(request,response);
		
	}
	
	
	
	
}