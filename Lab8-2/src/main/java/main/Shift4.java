package main;

public class Shift4 implements Shift{
    Car car;

    public Shift4(Car car) {
        this.car = car;
    }
    @Override
    public int getShift() {
        return 4;
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
        return speed>30 && speed<55;
    }
}
