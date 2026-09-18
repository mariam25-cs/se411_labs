package edu.psu.se411;

import edu.psu.se411.exceptions.InvalidAgeException;
import edu.psu.se411.wallet.WalletAccount;
import edu.psu.se411.exceptions.InsufficientFundsException;

public class App {

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older. Provided age: " + age);
        }
        System.out.println("Age valid.");
    }

    public static void main(String[] args) {
        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            validateAge(21);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        
        WalletAccount wallet = new WalletAccount(100.0);
        try {
            wallet.withdraw(150.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }

        try {
            wallet.withdraw(50.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
        
        
    }
}