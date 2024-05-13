package main;

import java.util.function.Consumer;

public class HireCounterConsumer implements Consumer<Hire> {
    private int count = 0;

    public void accept(Hire hire) {
        count++;
    }

    public int getCount() {
        return count;
    }
}
