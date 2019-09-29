package doa;

import entities.Customer;

public interface DoaInterface {
	int checkuser(String username, String password, String usertype);
	
	Customer getCustomerProfile(int id);
	
	void addCustomer(Customer customer,String username,String password);
}
