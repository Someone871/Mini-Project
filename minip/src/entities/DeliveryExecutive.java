package entities;

public class DeliveryExecutive {
	private int emp_id;
	private String EmpName;
	private String WorkZone;
	private String EmpMobNo;

	public int getEmp_id() {
		return emp_id;
	}
	
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}
	
	public String getWorkZone() {
		return WorkZone;
	}
	
	public void setWorkZone(String workZone) {
		WorkZone = workZone;
	}
	
	public String getEmpMobNo() {
		return EmpMobNo;
	}
	
	public void setEmpMobNo(String empMobNo) {
		EmpMobNo = empMobNo;
	}
}
