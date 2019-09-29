package doa;

import java.sql.*;
import java.util.*;
import connectionUtil.DBConnectionUtil;
import entity.PeopleInfo;

public class DoaInterfaceImple implements DoaInterface {

		
	//define the properties
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		
		
	
	@Override
	public List<PeopleInfo> displaylist() {
		
		//create a reference variable
		//List<PeopleInfo> list=null;
		//PeopleInfo info=null;
		
		
		return null;
	}

	@Override
	public void save(PeopleInfo pi) {
	
	
		try {
			
		
			
			String sql="INSERT INTO Customer(fullname,address,area,mobno,email,username) VALUES('"+pi.getName()+"','"+pi.getAddress()+"','"+pi.getArea()+"','"+pi.getMobno()+"','"+pi.getEmail()+"','"+pi.getUsername()+"'  )";
			connection=DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
			
			/*
			 * I am trying to retrieve cust_id (which is auto generated) from customer table and trying to 
			 * insert into CustomerLogin table since it is a foreign key there 
			  */
			
			String SQL="SELECT cust_id from Customer where username='"+pi.getUsername()+"'";
			connection=DBConnectionUtil.openConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(SQL); 
			
			sql="INSERT INTO CustomerLogin(username,password,cust_id) VALUES('"+pi.getUsername()+"','"+pi.getPassword()+"','"+resultSet.getInt("cust_id")+"' )";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		
		}
		catch(SQLException E) 
		{
			E.printStackTrace(); 
			
		}
	
	
	}

	@Override
	public boolean checkuser(String username, String password) {
		
		try {
			String sql=" SELECT * FROM CustomerLogin WHERE username='"+username+"' AND password='"+password+"' ";
			connection=DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			
			//System.out.println(resultSet.getLong("cust_id"));
			
			if(!resultSet.next())
				return false;
			return true;
		}
		catch(SQLException E) 
		{
			E.printStackTrace(); 
			
		}
		
		return false;
	}

}
