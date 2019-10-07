package entities;

public class Order {
	private int order_id;
	private int cust_id;
	private int chef_id;
	private int emp_id;
	private String status;
	private int total_cost;
	private int NumOrdered;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public int getChef_id() {
		return chef_id;
	}
	public void setChef_id(int chef_id) {
		this.chef_id = chef_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}
	public int getNumOrdered() {
		return NumOrdered;
	}
	public void setNumOrdered(int numOrdered) {
		NumOrdered = numOrdered;
	}
}