package doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbConnection.DBConnection;
import entities.Chef;
import entities.ChefCustomer;
import entities.Customer;
import entities.DeliveryExecutive;

public class DoaImpl implements DoaInterface{
	/*-------------------------- GET ZONE FROM AREA --------------------------*/

	@Override
	public String getZone(String area) {
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		try{
			String sql = "SELECT Zone FROM Location WHERE Area = '"+area+"'";
			connection = DBConnection.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();			
			resultSet.beforeFirst();
			resultSet.next();
			String Zone = resultSet.getString("Zone");
			
			return Zone;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*-------------------------- CHECK USER LOGIN AND RETURN ID --------------------------*/
	@Override
	public int checkuser(String username, String password, String usertype) {
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		try {
			String sql = new String();
			
			System.out.println("\nDetails Received :: "+username+"\t"+password+"\t"+usertype+"\n");
			
			if(usertype.equals("chef"))
				sql = "SELECT * FROM ChefLogin WHERE username='"+username+"' AND password='"+password+"'";
			else if(usertype.equals("cust"))
				sql = "SELECT * FROM CustomerLogin WHERE username='"+username+"' AND password='"+password+"'";
			else
				sql = "SELECT * FROM EmpLogin WHERE username='"+username+"' AND password='"+password+"'";
			
			System.out.println(sql);
			
			connection = DBConnection.openConnection();
			
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(!resultSet.next()) {
				return -1;
			}
			if(usertype.equals("chef")) {
				int id = resultSet.getInt("chef_id");
				System.out.println(resultSet.getInt("chef_id"));
				System.out.println(resultSet.getString("username"));
				System.out.println(resultSet.getString("password"));
				return id;
			}
				
			else if(usertype.equals("cust")) {
				int id = resultSet.getInt("cust_id");
				System.out.println(resultSet.getInt("cust_id"));
				System.out.println(resultSet.getString("username"));
				System.out.println(resultSet.getString("password"));
				return id;
			}
				
			else {
				System.out.println("Here i am");
				int id = resultSet.getInt("emp_id");
				System.out.println(resultSet.getInt("emp_id"));
				System.out.println(resultSet.getString("username"));
				System.out.println(resultSet.getString("password"));
				return id;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/*------------------------------------ CUSTOMER SIGNUP --------------------------------------------*/
	@Override
	public void addCustomer(Customer customer,String username,String password) {
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		try {
			// Insert Customer details into Customer table  
			
			String sql = "INSERT INTO Customer(fullname,address,area,mobno,email) VALUES ('"+customer.getFullname()+"','"+customer.getAddress()+"','"+customer.getArea()+"','"+customer.getMobno()+"','"+customer.getEmail()+"')";
			connection = DBConnection.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
			System.out.println(sql);
			// Retrieve last-inserted customer id from database 
			sql = "SELECT LAST_INSERT_ID() AS last";
			System.out.println(sql);
			connection = DBConnection.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			resultSet.beforeFirst();
			resultSet.next();
			int id = resultSet.getInt("last");
			
			System.out.println(id);
			
			// Insert id,username, password into CustomerLogin table
			sql = "INSERT INTO CustomerLogin VALUES('"+username+"','"+password+"','"+id+"')";
			System.out.println(sql);
			connection = DBConnection.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
			System.out.println(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	/*---------------------------------------- RETURN CUSTOMER PROFILE FROM ID ------------------------------------------*/
	@Override
	public Customer getCustomerProfile(int id) {
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		try {
			String sql = "SELECT * FROM Customer WHERE cust_id="+id;
			
			System.out.println(sql);
			
			connection=DBConnection.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			resultSet.beforeFirst();
			resultSet.next();
			
			Customer customer=new Customer();
			customer.setCust_id(id);
			customer.setFullname(resultSet.getString("fullname"));
			customer.setAddress(resultSet.getString("address"));
			customer.setArea(resultSet.getString("area"));
			customer.setMobno(resultSet.getString("mobno"));
			customer.setEmail(resultSet.getString("email"));
			
			return customer;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*----------------------------------------- RETURN DELIVER EXECUTIVE PROFILE -------------------------------------*/
	@Override
	public DeliveryExecutive getDeliveryExecutiveProfile(int id) {
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		
		try {
			String sql="SELECT * FROM DeliveryExecutive where emp_id="+id;
			connection=DBConnection.openConnection();
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			
			System.out.println(sql);
			
			DeliveryExecutive deliveryexecutive = new DeliveryExecutive();
			deliveryexecutive.setEmp_id(id);
			
			resultSet.beforeFirst();
			resultSet.next();
			
			deliveryexecutive.setEmpName(resultSet.getString("EmpName"));
			deliveryexecutive.setWorkZone(resultSet.getString("WorkZone"));
			deliveryexecutive.setEmpMobNo(resultSet.getString("EmpMobNo"));
			
			return deliveryexecutive;
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	/*------------------------------------------- SHOW TIFFINS THE CUSTOMER CAN ORDER ----------------------------------------*/
	@Override
	public List<Chef> getPotentialOrders(int id) {
		System.out.println("\n!!-- Retrieving Potential Orders --!!\n");
		
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		
		List<Chef> list = null;
		Customer customer = getCustomerProfile(id);
		Chef chef = null;
		
		try {
			list = new ArrayList<Chef>();
			
			String sql = "SELECT * FROM Chef WHERE ( NumAvl>0 AND (SELECT Zone from location where area=Chef.area)='"+getZone(customer.getArea())+"')";
			System.out.println(sql);
			connection = DBConnection.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			int i=0;
			resultSet.beforeFirst();
			while(resultSet.next()) {
				chef = new Chef();
				chef.setChef_id(resultSet.getInt("chef_id"));
				chef.setname(resultSet.getString("fullname"));
				chef.setAddress(resultSet.getString("address"));
				chef.setArea(resultSet.getString("area"));
				chef.setMobno(resultSet.getString("mobno"));
				chef.setCuisine(resultSet.getString("cuisine"));
				chef.setNumAvl(resultSet.getInt("NumAvl"));
				chef.setUnitCost(resultSet.getInt("UnitCost"));
				chef.setTiffinDesc(resultSet.getString("TiffinDesc"));
				i++;
				list.add(chef);
				
				System.out.println(chef.getChef_id());
			}
			System.out.println("\nI = = "+i);
			
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*-------------------------- RETURN CHEF PROFILE FROM ID --------------------------*/
	@Override
	public Chef getChefProfile(int id) {
		
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		
		try {
			String sql="SELECT * FROM Chef where chef_id="+id;
			connection=DBConnection.openConnection();
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			
			System.out.println(sql);
			
			Chef chef = new Chef();
			chef.setChef_id(id);
			
			resultSet.beforeFirst();
			resultSet.next();
			
			chef.setName(resultSet.getString("fullname"));
			chef.setAddress(resultSet.getString("address"));
			chef.setMobno(resultSet.getString("mobno"));
			
			return chef;
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateMenu(Chef chef) {
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try {
			String sql="UPDATE Chef SET "
					+ "cuisine = ? ,"
					+ "NumAvl = ? ,"
					+ "UnitCost = ? ,"
					+ "TiffinDesc = ? "
					+ "WHERE chef_id = ?";
			
			System.out.println(sql);
			
			connection=DBConnection.openConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,chef.getCuisine());
			preparedStatement.setInt(2,chef.getNumAvl());
			preparedStatement.setInt(3,chef.getUnitCost());
			preparedStatement.setString(4,chef.getTiffinDesc());
			preparedStatement.setInt(5,chef.getChef_id());
			
			//preparedStatement.setBigDecimal(arg0, arg1);
			
			preparedStatement.executeUpdate();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	


	@Override
	public List<ChefCustomer> getOrderInfo(int id) {
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		//int count=0;
		List<ChefCustomer> list=null;
			
		try {
			
			list=new ArrayList<ChefCustomer>();   //create an array list to add customer and chef details

			String sql1="SELECT * FROM OrderInfo WHERE emp_id="+id+" and (status='C' OR status='D')";
			System.out.println(sql1);
			connection = DBConnection.openConnection();
			preparedStatement = connection.prepareStatement(sql1);
			resultSet = preparedStatement.executeQuery();
			resultSet.beforeFirst();
//			resultSet.next();
			//int count=resultSet.getInt(1);
	
			while(resultSet.next())
			{
				//getting chef_id,cust_id 
				int chef_id = resultSet.getInt("chef_id");
				int cust_id = resultSet.getInt("cust_id");
				
				ChefCustomer chefcustomerinfo=new ChefCustomer();
				
				Customer customer = getCustomerProfile(cust_id); //get customer profile 
				Chef chef = getChefProfile(chef_id);             //get chef profile
				
				//from customer profile pull name,address and mobno
				chefcustomerinfo.setCustomerId(cust_id);
				chefcustomerinfo.setCustomerName(customer.getFullname());
				chefcustomerinfo.setCustomerAddress(customer.getAddress());
				chefcustomerinfo.setCustomerMobNo(customer.getMobno());
		
				//from chef profile pull name,address and mobno
				chefcustomerinfo.setChefId(chef_id);
				chefcustomerinfo.setChefName(chef.getName());
				chefcustomerinfo.setChefAddress(chef.getAddress());
				chefcustomerinfo.setChefMobNo(chef.getMobno());

				list.add(chefcustomerinfo);	
				}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}		
		return list;
	}
	
	
	
	@Override
	public int insertOrder(int id, int chef_id, int NumOrdered, int total_cost) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		
		try {
			/* Insert Order into OrderInfo Table */
			String sql = "INSERT INTO OrderInfo(cust_id,chef_id,status,total_cost,NumOrdered) VALUES("
					+ id +","
					+chef_id+","
					+"'W',"
					+total_cost+","
					+NumOrdered+")";
			connection = DBConnection.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			try {
				int err = preparedStatement.executeUpdate();
				if(err==0)
					return -1;
	
				/* Retrieve OrderID */
				sql = "SELECT LAST_INSERT_ID() AS last";
				System.out.println(sql);
				connection = DBConnection.openConnection();
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				resultSet.beforeFirst();
				resultSet.next();
				int order_id = resultSet.getInt("last");
				
				sql = "select min(emp_id) as empid from DeliveryExecutive where state='F'";
				connection = DBConnection.openConnection();
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				resultSet.next();
				int empid = resultSet.getInt("empid");
				
				sql = "update table OrderInfo set emp_id="+empid+"where order_id="+order_id;
				connection = DBConnection.openConnection();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				
				sql = "update DeliveryExecutive set state='B' where emp_id = "+empid;
				connection = DBConnection.openConnection();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				
				return order_id;
			}
			catch(Exception e) {
				return -1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
