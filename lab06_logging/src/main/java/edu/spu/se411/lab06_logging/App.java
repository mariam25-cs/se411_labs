package edu.spu.se411.lab06_logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.spu.se411.lab06_logging.exceptions.InsufficientFundsException;
import edu.spu.se411.lab06_logging.model.WalletAccount;

public class App {

    static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("Application is starting...");

        WalletAccount account = new WalletAccount(1000);
        logger.debug("Wallet account created with balance 1000");

        try {
            logger.debug("Attempting to withdraw 1500");
            account.withdraw(1500);
        } catch (InsufficientFundsException e) {
            logger.error("Exception thrown during withdraw: " + e.getMessage());
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            logger.debug("Attempting to deposit -100");
            account.deposit(-100);
        } catch (IllegalArgumentException e) {
            logger.error("Exception thrown during deposit: " + e.getMessage());
            System.out.println("Exception caught: " + e.getMessage());
        }

        logger.info("Application is ending...");
    }
}