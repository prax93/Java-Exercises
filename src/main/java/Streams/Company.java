package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	static int[] numbers = {0,5,10,20,5,20};

	static List<String> stringList = new ArrayList<>();

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
		System.out.println(countLetter('l'));
	}

	private static int minSalary() {
		return employees.stream().min(Comparator.comparing(Employee::salary)).orElseGet(() -> new Employee("", "", 0)).salary;
	}

	private static int maxSalary() {
		return employees.stream().max(Comparator.comparing(Employee::salary)).orElse(new Employee("", "", 0)).salary();
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

	private static Double averAgeNumbers(){
		return Arrays.stream(numbers).average().orElse(0);
	}

	private static List<String> lowerCaser(){
		return employees.stream().map(employee -> employee.toString().toLowerCase()).toList();
	}

	private static int oddSums(){
		return Arrays.stream(numbers)
				.filter(n -> n%2 == 0)
				.sum();
	}


	private static long countLetter(char search){
		stringList.add("Hello");
		stringList.add("World");


		return stringList.stream().
				flatMap(str -> str.chars().mapToObj(c -> (char)c)).filter(c -> c.equals(search)).count();


	}

}
