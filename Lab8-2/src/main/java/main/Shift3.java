package main;

public class Shift3 implements Shift{
    Car car;

    public Shift3(Car car) {
        this.car = car;
    }
    @Override
    public int getShift() {
        return 3;
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
        return speed>10 && speed<30;
    }
}
