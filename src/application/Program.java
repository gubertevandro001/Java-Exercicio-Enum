package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter department's name: ");
		String nameDepartment = sc.next();				
		System.out.println("Enter worker data: ");
		System.out.println("Name: ");
		String name = sc.next();
		System.out.println("Level: ");
		String level = sc.next();
		System.out.println("Base Salary: ");
		double baseSalary = sc.nextDouble();		
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(nameDepartment));

		System.out.println("How many contracts to this worker? ");
		int numberContracts = sc.nextInt();
		
		for (int nc = 0; nc < numberContracts; nc ++) {
			System.out.println("Enter contract #" + (nc + 1) + " data:");
			System.out.println("Date (DD/MM/YYYY): ");
			Date date = sdf.parse(sc.next());
			System.out.println("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.println("Duration hours: ");
			int durationHours = sc.nextInt();
			HourContract hourContract = new HourContract(date, valuePerHour, durationHours);
			worker.addContract(hourContract);
			
		}	
		
		System.out.println("\nEnter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));		
		System.out.println(worker);
		System.out.println("Income for " + month + "/" + year + ": " + worker.income(year, month));
	}
	
}
