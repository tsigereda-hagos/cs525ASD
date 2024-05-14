package edu.mum.cs.cs525.labs.skeleton;

import java.util.Collection;
import java.util.Stack;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;
	private Stack<Command> commandHistory = new Stack<>();
	private Stack<Command> undoHistory = new Stack<>();
	
	public AccountServiceImpl(){
		accountDAO = new AccountDAOImpl();
	}

	public Account createAccount(String accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		
		accountDAO.saveAccount(account);
		
		return account;
	}

//	public void deposit(String accountNumber, double amount) {
//		Account account = accountDAO.loadAccount(accountNumber);
//		account.deposit(amount);
//
//		accountDAO.updateAccount(account);
//	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		Command depositCommand = new DepositCommand(account, amount);
		depositCommand.execute();
		commandHistory.push(depositCommand); // Store command for potential undo
		undoHistory.clear(); // Clear redo history
		accountDAO.updateAccount(account);
	}

	public Account getAccount(String accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

//	public void withdraw(String accountNumber, double amount) {
//		Account account = accountDAO.loadAccount(accountNumber);
//		account.withdraw(amount);
//		accountDAO.updateAccount(account);
//	}

	public void withdraw(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		Command withdrawCommand = new WithdrawCommand(account, amount);
		withdrawCommand.execute();
		commandHistory.push(withdrawCommand); // Store command for potential undo
		undoHistory.clear(); // Clear redo history
		accountDAO.updateAccount(account);
	}


//	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
//		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
//		Account toAccount = accountDAO.loadAccount(toAccountNumber);
//		fromAccount.transferFunds(toAccount, amount, description);
//		accountDAO.updateAccount(fromAccount);
//		accountDAO.updateAccount(toAccount);
//	}

	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		Command transferCommand = new TransferFundsCommand(fromAccount, toAccount, amount);
		transferCommand.execute();
		commandHistory.push(transferCommand); // Store command for potential undo
		undoHistory.clear(); // Clear redo history
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}

	public void undo() {
		if (!commandHistory.isEmpty()) {
			Command lastCommand = commandHistory.pop();
			lastCommand.undo();
			undoHistory.push(lastCommand); // Store for potential redo
			accountDAO.updateAccount(lastCommand.getAccount());
		}
	}

	public void redo() {
		if (!undoHistory.isEmpty()) {
			Command undoneCommand = undoHistory.pop();
			undoneCommand.execute();
			commandHistory.push(undoneCommand); // Store for potential undo
			accountDAO.updateAccount(undoneCommand.getAccount());
		}
	}
}
