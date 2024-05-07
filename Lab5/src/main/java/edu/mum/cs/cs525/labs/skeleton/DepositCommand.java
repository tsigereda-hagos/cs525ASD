package edu.mum.cs.cs525.labs.skeleton;

public class DepositCommand implements Command{

    private Account account;
    private double amount;

    public DepositCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
    }

    @Override
    public void undo() {
        account.withdraw(amount);

    }

    @Override
    public Account getAccount() {
        return account;
    }
}
