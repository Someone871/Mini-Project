package doa;

import entities.Customer;

public interface DoaInterface {
	int checkuser(String username, String password, String usertype);
	
	Customer getCustomerProfile(int id);
}
