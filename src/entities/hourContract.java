package entities;

import java.util.Date;

public class hourContract {

	private Date date;
	private Double valuePerHour;
	private Integer hours;
	
	public hourContract() {
	
	}

	public hourContract(Date date, Double valueperhour, Integer hours) {
		super();
		this.date = date;
		this.valuePerHour = valueperhour;
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValueperhour() {
		return valuePerHour;
	}

	public void setValueperhour(Double valueperhour) {
		this.valuePerHour = valueperhour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public double totalValue() {
		return valuePerHour * hours;
	}
	
	
	
}
