package edu.mum.cs.cs525.labs.skeleton;

public class Promotion1 extends InterestPromotionDecorator{

    public Promotion1(InterestStrategy interestStrategy){
        super(interestStrategy);
    }
    @Override
    public double calculateInterest(double balance) {
        return getInterestStrategy().calculateInterest(balance) +balance * 0.01;
    }
}
