package edu.mum.cs.cs525.labs.skeleton;

public abstract class InterestPromotionDecorator implements InterestStrategy {
    InterestStrategy interestStrategy;

    public InterestPromotionDecorator(InterestStrategy interestStrategy) {
        this.interestStrategy = interestStrategy;
    }

    public InterestStrategy getInterestStrategy() {
        return interestStrategy;
    }
}
