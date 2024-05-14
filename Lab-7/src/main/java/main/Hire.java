package main;

import java.util.function.Consumer;

public abstract class Hire {
    protected String name;
    protected double salary;
    protected String email;

    public Hire(String name, double salary, String email) {
        this.name = name;
        this.salary = salary;
        this.email = email;
    }

    public abstract double getTotalSalary();

    public abstract void accept(Consumer<? super Hire> action);
}
