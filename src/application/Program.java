package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		// Para receber data nesse formato
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Nome do departamento : ");
		String departName = sc.nextLine();
		
		System.out.println("------- Dados do contrato de trabalho ------- : ");
		
		System.out.print("Nome do trabalhador : ");
		String workerName = sc.nextLine();
		
		System.out.print("Nivel do trabalhador : ");
		String levelWorker = sc.nextLine();
		
		
		System.out.print("Salário base : ");
		double basesalary = sc.nextDouble();
		
		// Instanciar
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(levelWorker), basesalary, new Department(departName));
	
		System.out.println("------------------------");
		
		System.out.print("Quantos contrato tem esse trabalhador : ");
		int qtdeContract = sc.nextInt();
		
		// Cadastrar os contratos do trabalhador
		
		for (int i=1; i<= qtdeContract; i++) {
			System.out.println("----- Enter contract #" + i + " data: -----");
			
			System.out.print("Data (DD/MM/YYYY): ");
			Date contratcDate = sdf.parse(sc.next());
			
			System.out.print("Value per hour :");
			double perHour = sc.nextDouble();
			
			System.out.print("Daration (hours) :");
			int durationHours = sc.nextInt();
			
			// Intanciar os contratos
			HourContract contract = new HourContract(contratcDate, perHour, durationHours);
			
			// Associar os contratos com o trabalhador
			worker.addContract(contract);
					
			
		}
		
		System.out.println("------ Calcular o total de horas trabalhado no mes --------");
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String monthYear = sc.next();
		int month = Integer.parseInt(monthYear.substring(0,2));
		int year = Integer.parseInt(monthYear.substring(3));
		
		System.out.println("----- Dados de ganho do trabalhador no mes -----");
		
		System.out.println("Name : " + worker.getName() );
		System.out.println("Department : " +  worker.getDepartment().getName());
		System.out.println("Ganhos do periodo : " + monthYear + " total : " + String.format("%.2f", worker.income(year, month)));
				
		
		 sc.close();

	}

}
