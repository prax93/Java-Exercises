package Streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Company {

	public record Employee(String name, String department, int salary) {
		public String toString() {
			return name;
		}
	}

	private static final List<Employee> employees = List.of(
			new Employee("John", "QA", 55000),
			new Employee("Rob", "QA", 53000),
			new Employee("Peter", "QA", 40000),
			new Employee("Frank", "Engineering", 41000),
			new Employee("Scott", "Engineering", 60000),
			new Employee("Sue", "Engineering", 62000),
			new Employee("Stephanie", "Engineering", 54000),
			new Employee("Jennifer", "Engineering", 45000),
			new Employee("Sarah", "QA", 52000),
			new Employee("Joan", "Engineering", 59000)
	);

	public static void main(String[] args) {
		System.out.println("Minimum salary: " + minSalary());
		System.out.println("Maximum salary: " + maxSalary());
		System.out.println("Average salary: " + avgSalary());
		System.out.println();
		System.out.println("Average salary in QA department: " + avgSalary("QA"));
		System.out.println("Average salary in Engineering department: " + avgSalary("Engineering"));
		System.out.println();
		System.out.println("Employee with lowest salary: " + employeeLowestSalary());
		System.out.println("Employee with highest salary: " + employeeHighestSalary());
		System.out.println();
		System.out.println("Number of employees per department: " + numEmployeesDepartment());
		System.out.println("Average salary per department: " + avgSalaryDepartment());
	}

	private static int minSalary() {
		return employees.stream().min(Comparator.comparing(Employee::salary)).orElseGet(() -> new Employee("", "", 0)).salary;
	}

	private static int maxSalary() {
		return employees.stream().max(Comparator.comparing(Employee::salary)).get().salary();
	}

	private static double avgSalary() {
		return employees.stream().mapToDouble(Employee::salary).average().getAsDouble();
	}

	private static double avgSalary(String department) {
		return employees.stream().filter(employee -> employee.department.equals(department)).mapToDouble(Employee::salary).average().getAsDouble();
	}

	private static Employee employeeLowestSalary() {
		return employees.stream().filter(employee -> employee.salary == minSalary()).findAny().get();
	}

	private static Employee employeeHighestSalary() {
		return employees.stream()
				.filter(employee -> employee.salary == maxSalary())
				.findFirst().get();
	}

	private static Map<String, Long> numEmployeesDepartment() {
		return employees.stream().collect(Collectors.groupingBy(employee -> employee.department, Collectors.counting()));

	}

	private static Map<String, Double> avgSalaryDepartment() {
		return employees.stream().collect(Collectors.groupingBy(employee -> employee.department, Collectors.averagingDouble(Employee::salary)));
	}
}
