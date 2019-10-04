package doa;

import entities.Chef;
import entities.Customer;
import entities.DeliveryExecutive;

public interface DoaInterface {
	int checkuser(String username, String password, String usertype);
	
	Customer getCustomerProfile(int id);
	
	void addCustomer(Customer customer,String username,String password);
	
	DeliveryExecutive getDeliveryExecutiveProfile(int id);
	
	Chef getChefProfile(int id);
	
	void updateMenu(Chef chef);
}
