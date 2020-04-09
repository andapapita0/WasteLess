package persistent;

import java.util.Date;

public class FoodItem {
	private int id;
	private String name;
	private int quantity;
	private int calorie_value;
	private Date purchase_date;
	private Date expiration_date;
	private Date consumption_date;
	
	public FoodItem() {
		
	}
	
	public FoodItem(String name, int quantity, int calorie_value, Date purchase_date, Date expiration_date,
			Date consumption_date) {
		this.name = name;
		this.quantity = quantity;
		this.calorie_value = calorie_value;
		this.purchase_date = purchase_date;
		this.expiration_date = expiration_date;
		this.consumption_date = consumption_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCalorie_value() {
		return calorie_value;
	}

	public void setCalorie_value(int calorie_value) {
		this.calorie_value = calorie_value;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public Date getConsumption_date() {
		return consumption_date;
	}

	public void setConsumption_date(Date consumption_date) {
		this.consumption_date = consumption_date;
	}

	@Override
	public String toString() {
		return "FoodItem [id=" + id + ", name=" + name + ", quantity=" + quantity + ", calorie_value=" + calorie_value
				+ ", purchase_date=" + purchase_date + ", expiration_date=" + expiration_date + ", consumption_date="
				+ consumption_date + "]";
	}
	
	public long getDays() {
		long days = this.expiration_date.getTime() - this.purchase_date.getTime();
		return days / (1000*60*60*24);
	}
	
	public long burndownRate() {
		return this.getCalorie_value() / this.getDays();
	}
	
	public boolean waste() {
		Date current= new Date();
		if(this.getConsumption_date()==null && current.compareTo(this.getExpiration_date()) > 0) {
			return true;
		}
		else return false;
	}
	
	public boolean twoDaysBeforeExpiration() {
		Date current = new Date();
		if((this.getExpiration_date().getTime() - current.getTime()) / (1000*60*60*24) == 2)
			return true;
		else return false;
	}
	
	public boolean oneDayBeforeExpiration() {
		Date current = new Date();
		if((this.getExpiration_date().getTime() - current.getTime()) / (1000*60*60*24) == 1)
			return true;
		else return false;
	}
	
	public boolean todaysReminder() {
		Date current = new Date();
		if(this.getExpiration_date().compareTo(current) > 0)
			return true;
		else return false;
	}
}
