package edu.mum.cs.cs525.labs.skeleton;

public class Promotion2 extends InterestPromotionDecorator{
    public Promotion2(InterestStrategy interestStrategy){
        super(interestStrategy);
    }

    @Override
    public double calculateInterest(double balance) {
        return getInterestStrategy().calculateInterest(balance) + balance * 0.02;
    }
}
