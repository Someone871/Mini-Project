package entities;

public class Chef {
	private Integer chef_id;
	private String address;
	private String area;
	private String mobno;
	private String cuisine;
	private Integer NumAvl;
	private Integer UnitCost;
	private String TiffinDesc;
	public Integer getChef_id() {
		return chef_id;
	}
	public void setChef_id(Integer chef_id) {
		this.chef_id = chef_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public Integer getNumAvl() {
		return NumAvl;
	}
	public void setNumAvl(Integer numAvl) {
		NumAvl = numAvl;
	}
	public Integer getUnitCost() {
		return UnitCost;
	}
	public void setUnitCost(Integer unitCost) {
		UnitCost = unitCost;
	}
	public String getTiffinDesc() {
		return TiffinDesc;
	}
	public void setTiffinDesc(String tiffinDesc) {
		TiffinDesc = tiffinDesc;
	}
}
