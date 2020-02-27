package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enuns.workerLevel;

public class worker {

	private String name;
	private workerLevel level;
	private Double baseSalary;

	private Department department;
	private List<hourContract> contracts = new ArrayList<>();

	public worker() {

	}

	public worker(String name, workerLevel level, Double basesalary, entities.Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = basesalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public workerLevel getLevel() {
		return level;
	}

	public void setLevel(workerLevel level) {
		this.level = level;
	}

	public Double getBasesalary() {
		return baseSalary;
	}

	public void setBasesalary(Double basesalary) {
		this.baseSalary = basesalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<hourContract> getContracts() {
		return contracts;
	}

	// adicionar o contrato
	public void addContract(hourContract contract) {
		contracts.add(contract);
	}

	// remover o contrato da lista
	public void removeContract(hourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (hourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	
	}
	
}
