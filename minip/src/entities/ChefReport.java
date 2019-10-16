package entities;

public class ChefReport {
	private String Date;
	private int count;
	private int sum;
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
}