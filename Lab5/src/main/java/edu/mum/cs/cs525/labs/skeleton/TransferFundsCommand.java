package edu.mum.cs.cs525.labs.skeleton;

public class TransferFundsCommand implements Command{
    private Account fromAccount;
    private Account toAccount;
    private double amount;

    public TransferFundsCommand(Account fromAccount, Account toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void execute() {
        fromAccount.transferFunds(toAccount, amount, "Transfer");
    }

    @Override
    public void undo() {
        toAccount.transferFunds(fromAccount, amount, "Transfer undo ");

    }

    @Override
    public Account getAccount() {
        return fromAccount;
    }
}
