package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.println("How many employee will be registered?");

		int qtd = sc.nextInt();

		for (int i = 0; i < qtd; i++) {

			System.out.println("Employee #" + (i + 1));
			System.out.print("id: ");
			int id = sc.nextInt();

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Salary: ");
			double sal = sc.nextDouble();

			list.add(new Employee(id, name, sal));

		}

		System.out.print("\n Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.aumentoSalarial(percentage);
		}

		System.out.println(list);

		sc.close();

	}

}
