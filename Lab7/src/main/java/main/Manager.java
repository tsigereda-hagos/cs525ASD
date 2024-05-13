package main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Manager extends Hire{
    List<Hire> hires = new ArrayList<>();
    private int counter = 0;

    public Manager(double salary, String name) {
        super(salary, name);
    }
    public void addHire(Hire hire){
        hires.add(hire);
    }

    @Override
    public double getTotalSalary() {
        double totalSalary = getSalary();
        for(Hire hire: hires){
            totalSalary += hire.getTotalSalary();
        }
        return totalSalary;
    }

    @Override
    public void accept(Consumer<? extends Hire> action) {

    }
    

    @Override
    public int hireCounterConsumer() {
        int count =1;
        for(Hire hire: hires){
            count += hire.hireCounterConsumer();
        }
        return count;
    }
}
