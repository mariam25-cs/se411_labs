package edu.psu.se411.wallet;

import edu.psu.se411.exceptions.InsufficientFundsException;

public class WalletAccount {
    private double balance;

    public WalletAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Insufficient funds: tried to withdraw " + amount + " but balance is only " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }
}