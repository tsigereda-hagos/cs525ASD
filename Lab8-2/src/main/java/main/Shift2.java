package main;

public class Shift2 implements Shift {
    Car car;

    public Shift2(Car car) {
        this.car = car;
    }
    @Override
    public int getShift() {
        return 2;
    }

    @Override
    public int shiftNumber() {
        //        return car.getState().getShift();
        return getShift();
    }
    @Override
    public void checkSpeed(int speed) {
        if(isMySpeedLimit(speed)){
            car.setState(this);
        }
    }
    private boolean isMySpeedLimit(int speed){
        return speed>5 && speed<10;
    }

}
