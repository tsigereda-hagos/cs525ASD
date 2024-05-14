package main;

public class Shift1 implements Shift {
    Car car;

    public Shift1(Car car) {
        this.car = car;
    }
    @Override
    public int getShift() {
        return 1;
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
        return speed>0 && speed<5;
    }


}
