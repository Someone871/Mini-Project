package loginController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doa.DoaInterfaceImple;
import entity.PeopleInfo;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	DoaInterfaceImple logindoa;
	
	
    
   
    public Login() {
        logindoa=new DoaInterfaceImple();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address=request.getParameter("address");
		String area=request.getParameter("area");
		String mobno=request.getParameter("mobno");
		String email=request.getParameter("email");
		String name=request.getParameter("cusname");
		
		//int cust_id=Integer.parseInt(request.getParameter("cust_id"));
		String username=request.getParameter("username");
		String pass=request.getParameter("password");
		String action=request.getParameter("perform");
		
		
		PeopleInfo pi=new PeopleInfo();
		pi.setAddress(address);
		pi.setArea(area);
		pi.setMobno(mobno);
		pi.setEmail(email);
		pi.setName(name);
	
		//pi.setCus_id(cust_id);
		pi.setPassword(pass);
		pi.setUsername(username);
		
	    if(action.equals("add"))
	    	logindoa.save(pi);
	    
		
		
		
		//request.getRequestDispatcher("Views/Welcome.jsp").forward(request, response);
	}

}












