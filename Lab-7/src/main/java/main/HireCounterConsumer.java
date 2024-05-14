package main;

import java.util.function.Consumer;

public class HireCounterConsumer implements Consumer<Hire> {
    private int hireCount = 0;

    @Override
    public void accept(Hire hire) {
        hireCount++;
    }

    public int getHireCount() {
        return hireCount;
    }
}
