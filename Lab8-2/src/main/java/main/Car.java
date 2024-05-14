package main;

import java.util.ArrayList;
import java.util.List;

public class Car{
    List<Shift> shiftList;
    Shift shift0;
    Shift shift1;
    Shift shift2;
    Shift shift3;
    Shift shift4;
    Shift shift5;
    Shift state;
    int speed = 0;

    public Car() {
        shift0= new Shift0(this);
        shift1= new Shift1(this);
        shift2= new Shift2(this);
        shift3= new Shift3(this);
        shift4= new Shift4(this);
        shift5= new Shift5(this);

        state= new Shift0(this);
        shiftList = new ArrayList<>();
        shiftList.add(shift0);
        shiftList.add(shift1);
        shiftList.add(shift2);
        shiftList.add(shift3);
        shiftList.add(shift4);
        shiftList.add(shift5);
    }

    public Shift getState() {
        return state;
    }


    public int changeSpeed(int speed){
        this.speed = speed;
        for(Shift shift: shiftList){
            shift.checkSpeed(speed);
        }
        return state.shiftNumber();
    }

    public void setState(Shift state) {
        this.state = state;
    }
}