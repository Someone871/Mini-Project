package doa;

import java.util.List;

import entities.Chef;
import entities.ChefCustomer;
import entities.Customer;
import entities.DeliveryExecutive;

public interface DoaInterface {
	String getZone(String area);
	
	int checkuser(String username, String password, String usertype);
	
	Customer getCustomerProfile(int id);
	
	void addCustomer(Customer customer,String username,String password);
	
	DeliveryExecutive getDeliveryExecutiveProfile(int id);
	List<ChefCustomer>  getOrderInfo(int id);
	
	Chef getChefProfile(int id);
	void updateMenu(Chef chef);
	List<Chef> getPotentialOrders(int id);
	
	int insertOrder(int id,int chef_id,int NumOrdered,int total_cost);
	
}
