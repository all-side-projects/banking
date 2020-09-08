package bank;

import java.util.Scanner;

public class BankAccount extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int balance, lastTransaction;
	String name, id;

	public BankAccount(String exception) {
	}

	public BankAccount(String name, String id, int balance) {
		super();
		this.balance = balance;
		this.id = id;
		this.name = name;
	}

	void deposit(int amount) {
		if (amount > 0) {
			balance = balance + amount;
			lastTransaction = amount;
		} else
			throw new IllegalArgumentException("Amount must be greater than 0");

	}

	void withdraw(int amount) {
		try {
			if (balance > 0) {
				balance = balance - amount;
				lastTransaction = amount * -1;
			}
			if (balance <= 0) {
				BankAccount exception = new BankAccount("The balance of your account is 0");
				throw exception;
			}
		} catch (BankAccount e) {
			e.printStackTrace();
		}
	}

	void getPreviousTransactions() {
		if (lastTransaction > 0) {
			System.out.println("Deposited: " + lastTransaction);
		} else if (lastTransaction < 0) {
			System.out.println("Withdrawn: " + lastTransaction * -1);
		} else
			System.out.println("No transaction occured");
	}

	@SuppressWarnings("resource")
	void menu() {
		char option = ' ';
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome " + name);
		System.out.println("Your ID is " + id + "\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");

		do {
			System.out.println("==============================================================================================================");
			System.out.print("Enter an option> ");
			option = input.next().charAt(0);
			switch (option) {
			case 'A':
				System.out.println("---------------------");
				System.out.println("Balance = " + balance);
				break;

			case 'B':
				System.out.println("---------------------");
				System.out.println("Enter an amount to deposit:");
				int amountDeposit = input.nextInt();
				deposit(amountDeposit);
				break;

			case 'C':
				System.out.println("---------------------");
				System.out.println("Enter an amount to withdraw:");
				int amountWithdraw = input.nextInt();
				withdraw(amountWithdraw);
				break;

			case 'D':
				System.out.println("---------------------");
				getPreviousTransactions();
				break;
				
			case 'E':
				System.out.println("Thank you for using our service!");
				break;
				
			default:
				System.out.println("Invalid Option! Please enter again.");
				break;
			}
		} while (option != 'E');
	}

}
