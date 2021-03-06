package entities;

public class ChefCustomer {

	
	private String ChefName;
	private String CustomerName;
	private String ChefMobNo;
	private String CustomerMobNo;
	private String ChefAddress;
	private String CustomerAddress;
	private int ChefId;
	private int CustomerId;
	private String Status;
	private int OrderId;
	private int EmpId;
	
	
	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public String getChefName() {
		return ChefName;
	}
	
	public void setChefName(String chefName) {
		ChefName = chefName;
	}

	public String getCustomerName() {
		return CustomerName;
	}
	
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	
	public String getChefMobNo() {
		return ChefMobNo;
	}

	public void setChefMobNo(String chefMobNo) {
		ChefMobNo = chefMobNo;
	}
	
	public String getCustomerMobNo() {
		return CustomerMobNo;
	}
	
	public void setCustomerMobNo(String customerMobNo) {
		CustomerMobNo = customerMobNo;
	}

	public String getChefAddress() {
		return ChefAddress;
	}
	
	public void setChefAddress(String chefAddress) {
		ChefAddress = chefAddress;
	}

	public String getCustomerAddress() {
		return CustomerAddress;
	}
	
	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}
	
	public int getChefId() {
		return ChefId;
	}
	
	public void setChefId(int chefId) {
		ChefId = chefId;
	}
	
	public int getCustomerId() {
		return CustomerId;
	}
	
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	
	
}
