package main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Manager extends Hire{
    private List<Hire> subordinates = new ArrayList<>();

    public Manager(String name, double salary, String email) {
        super(name, salary, email);
    }

    public void addSubordinate(Hire hire) {
        subordinates.add(hire);
    }

    public void removeSubordinate(Hire hire) {
        subordinates.remove(hire);
    }

    @Override
    public double getTotalSalary() {
        double totalSalary = salary;
        for (Hire subordinate : subordinates) {
            totalSalary += subordinate.getTotalSalary();
        }
        return totalSalary;
    }

    @Override
    public void accept(Consumer<? super Hire> action) {
        action.accept(this);
        for (Hire subordinate : subordinates) {
            subordinate.accept(action);
        }
    }
}
