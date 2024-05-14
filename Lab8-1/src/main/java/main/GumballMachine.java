package main;

import java.util.Random;

public class GumballMachine {

    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;
    Random randomWinner;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState();
        noQuarterState = new NoQuarterState();
        hasQuarterState = new HasQuarterState();
        soldState = new SoldState();
        winnerState = new WinnerState(this);
        randomWinner = new Random(System.currentTimeMillis());

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    public void insertQuarter() {
        if(state == noQuarterState){
            state.insertQuarter();
            setState(getHasQuarterState());
        }else {
            state.insertQuarter();
        }
    }

    public void ejectQuarter() {
        if(state == hasQuarterState){
            state.ejectQuarter();
            setState(noQuarterState);
        }else {
            state.ejectQuarter();
        }
    }

    public void turnCrank() {
        if(state==hasQuarterState){
            state.turnCrank();
            int winner = randomWinner.nextInt(10);
            if ((winner == 0) && (getCount() > 1)) {
                setState(getWinnerState());
            } else {
                setState(getSoldState());
            }
        }else {
            state.turnCrank();
        }
        dispense();
//        state.turnCrank();
//        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }

    private void dispense(){
        if (state == soldState){
            releaseBall();
            if(getCount()>0){
                setState(getNoQuarterState());
            }else {
                state.dispense();
                setState(getSoldOutState());
            }
        }else{
            state.dispense();
        }
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            count = count - 1;
        }
    }

    int getCount() {
        return count;
    }

    void refill(int count) {
        this.count += count;
        System.out.println("The gumball machine was just refilled; its new count is: " + this.count);
        if(state == soldOutState){
            setState(noQuarterState);
        }else {
            state.refill();
        }
//        state.refill();
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
}

