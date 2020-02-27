package contrato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.hourContract;
import entities.worker;

public class program {
	
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("enter departmet's name: ");
		String departmentName = sc.nextLine();
		System.out.println("enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.println("Level: ");
		String workerLevel = sc.nextLine();
		System.out.println("BAse Salary: ");
		double baseSalary = sc.nextDouble();
		
		worker worker = new worker(workerName, entities.enuns.workerLevel.valueOf(workerLevel) , baseSalary, new Department(departmentName));

		
		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("enter contract n " + i + ".data: ");
			System.out.print("date (DD/MM/yyyy): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("value per hoour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration(hours): ");
			int hours = sc.nextInt();
			
			hourContract contract = new hourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("enter month an year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName() );
		System.out.println("partment: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}
}
