package main;

import java.util.function.Consumer;

public class Employee extends Hire{
    private int counter=0;
    public Employee(double salary, String name) {
        super(salary, name);
    }
    @Override
    public double getTotalSalary(){
        return this.getSalary();
    }

    @Override
    public int hireCounterConsumer() {
        return 1;
    }

    @Override
    public void accept(Consumer<? extends Hire> action) {
        action= e-> System.out.println(e.getName() + " " + e.getSalary());
    }

    public void HireCounterConsumer(){
        counter++;
    }
}
