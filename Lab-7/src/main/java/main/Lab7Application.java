package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab7Application {

    public static void main(String[] args) {
        Manager ceo = new Manager("John Doe", 100000, "john.doe@email.com");
        Manager engineeringManager = new Manager("Alice Smith", 80000, "alice.smith@email.com");
        Employee engineer1 = new Employee("Bob Johnson", 60000, "bob.johnson@email.com");
        Employee engineer2 = new Employee("Carol Williams", 65000, "carol.williams@email.com");

        ceo.addSubordinate(engineeringManager);
        engineeringManager.addSubordinate(engineer1);
        engineeringManager.addSubordinate(engineer2);

        // Counting total number of hires
        HireCounterConsumer hireCounter = new HireCounterConsumer();
        ceo.accept(hireCounter);
        int totalHires = hireCounter.getHireCount();
        System.out.println("Total number of hires: " + totalHires);

        // Calculating total salary of all employees
        SalaryCalculatorConsumer salaryCalculator = new SalaryCalculatorConsumer();
        ceo.accept(salaryCalculator);
        double totalSalary = salaryCalculator.getTotalSalary();
        System.out.println("Total salary of all employees: $" + totalSalary);
    }

}
