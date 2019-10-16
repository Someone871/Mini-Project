package doa;

import java.util.List;

import entities.Chef;
import entities.ChefCustomer;
import entities.ChefReport;
import entities.Customer;
import entities.DeliveryExecutive;
import entities.Order;
import entities.Report;

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
	List<Order> getPendingOrders(int id);
	
	List<Order> getAcceptedOrders(int id);
	
	void acceptOrder(int id);
	
	void changeStatus(int id,String status);
	
	List<Order> getCurrentOrders(int id);
	
	int cancelOrder(int order_id,int emp_id,int chef_id,int NumOrdered);
	List<Chef> getPotentialOrders(int id,String cuisine);
	List<Order> getCustomerOrderHistory(int id);
	void rateOrder(int order_id,int chef_id,int emp_id,int chef_rating, int del_rating);
	List<Report> getReport(int id);
	
	List<ChefReport> chefReport(int id);
}
