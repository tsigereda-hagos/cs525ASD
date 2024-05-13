package main;

import java.util.function.Consumer;

public class SalaryCalculatorConsumer implements Consumer<Employee> {
    private int totalSalary = 0;

    public void accept(Employee employee) {
        totalSalary += employee.getSalary();
    }

    public int getTotalSalary() {
        return totalSalary;
    }
}
