package doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import dbConnection.DBConnection;
import entities.Customer;

public class DoaImpl implements DoaInterface{
	
	//define the properties
	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	PreparedStatement preparedStatement=null;
	
	@Override
	public int checkuser(String username, String password, String usertype) {
		try {
			String sql = new String();
			
			System.out.println("\nDetails Received :: "+username+"\t"+password+"\t"+usertype+"\n");
			
			if(usertype.equals("chef"))
				sql = "SELECT * FROM cheflogin WHERE username='"+username+"' AND password='"+password+"'";
			else if(usertype.equals("cust"))
				sql = "SELECT * FROM customerlogin WHERE username='"+username+"' AND password='"+password+"'";
			else
				sql = "SELECT * FROM emplogin WHERE username='"+username+"' AND password='"+password+"'";
			
			System.out.println(sql);
			
			connection = DBConnection.openConnection();
			
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			//statement = connection.createStatement();
			
			//resultSet = statement.executeQuery(sql);
			
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
	
	@Override
	public Customer getCustomerProfile(int id) {
		Customer customer = null;
		
		try {
			String sql = "SELECT * FROM Customer WHERE cust_id='"+id+"'";
			connection=DBConnection.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			customer=new Customer();
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
		
		return customer;
	}
	
	@Override
	public void addCustomer(Customer customer,String username,String password) {
		try {
			// Insert Customer details into Customer table  
			
			String sql = "INSERT INTO customer(fullname,address,area,mobno,email) VALUES ('"+customer.getFullname()+"','"+customer.getAddress()+"','"+customer.getArea()+"','"+customer.getMobno()+"','"+customer.getEmail()+"')";
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
			sql = "INSERT INTO customerlogin VALUES('"+username+"','"+password+"','"+id+"')";
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
}
