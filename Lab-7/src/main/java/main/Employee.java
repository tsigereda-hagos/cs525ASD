package main;

import java.util.function.Consumer;

public class Employee extends Hire{
    public Employee(String name, double salary, String email) {
        super(name, salary, email);
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }

    @Override
    public void accept(Consumer<? super Hire> action) {
        action.accept(this);
    }
}
