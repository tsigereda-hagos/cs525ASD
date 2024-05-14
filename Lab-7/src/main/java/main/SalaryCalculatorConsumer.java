package main;

import java.util.function.Consumer;

public class SalaryCalculatorConsumer implements Consumer<Hire> {
    private double totalSalary = 0.0;

    @Override
    public void accept(Hire hire) {
        totalSalary += hire.getTotalSalary();
    }

    public double getTotalSalary() {
        return totalSalary;
    }
}
