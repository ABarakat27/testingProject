package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create three accounts
        Account account1 = new Account(1001, 500.0);
        Account account2 = new Account(1002, 1000.0);
        Account account3 = new Account(1003, 2000.0);

        // Test all the attributes in the Account class for each account
        account1.deposit(100.0);

        account1.withdraw(50.0);
        account1.transfer(75.0, account2);
        account1.addLinkedAccount(account2);
        account1.removeLinkedAccount(account2);
        account1.payBill(50.0, "Electricity");
        double balance1 = account1.getBalance();
        List<Transaction> transactionHistory1 = account1.getTransactionHistory();
        List<Account> linkedAccounts1 = account1.getLinkedAccounts();
        List<Notification> notifications1 = account1.getNotifications();
        account1.setOverdraftLimit(100.0);
        double availableBalance1 = account1.getAvailableBalance();
        account1.closeAccount();
        boolean isClosed1 = account1.isClosed();

        account2.deposit(200.0);
        account2.withdraw(100.0);
        account2.transfer(150.0, account1);
        account2.addLinkedAccount(account1);
        account2.removeLinkedAccount(account1);
        account2.payBill(75.0, "Water");
        double balance2 = account2.getBalance();
        List<Transaction> transactionHistory2 = account2.getTransactionHistory();
        List<Account> linkedAccounts2 = account2.getLinkedAccounts();
        List<Notification> notifications2 = account2.getNotifications();
        account2.setOverdraftLimit(200.0);
        double availableBalance2 = account2.getAvailableBalance();
        account2.closeAccount();
        boolean isClosed2 = account2.isClosed();

        account3.deposit(500.0);
        account3.withdraw(250.0);
        account3.transfer(400.0, account2);
        account3.addLinkedAccount(account2);
        account3.removeLinkedAccount(account2);
        account3.payBill(100.0, "Gas");
        double balance3 = account3.getBalance();
        List<Transaction> transactionHistory3 = account3.getTransactionHistory();
        List<Account> linkedAccounts3 = account3.getLinkedAccounts();
        List<Notification> notifications3 = account3.getNotifications();
        account3.setOverdraftLimit(300.0);
        double availableBalance3 = account3.getAvailableBalance();
        account3.closeAccount();
        boolean isClosed3 = account3.isClosed();

        // Print all the information for each account
        System.out.println("Account 1:");
        System.out.println("Balance: " + balance1);
        System.out.println("Transaction History: " + transactionHistory1);
        System.out.println("Linked Accounts: " + linkedAccounts1);
        System.out.println("Notifications: " + notifications1);
        System.out.println("Available Balance: " + availableBalance1);
        System.out.println("Is Closed: " + isClosed1);

        System.out.println("Account 2:");
        System.out.println("Balance: " + balance2);
        System.out.println("Transaction History: " + transactionHistory2);
        System.out.println("Linked Accounts: " + linkedAccounts2);
        System.out.println("Notifications: " + notifications2);
        System.out.println("Available Balance: " + availableBalance2);
        System.out.println("Is Closed: " + isClosed2);

        System.out.println("Account 3:");
        System.out.println("Balance: " + balance3);
        System.out.println("Transaction History: " + transactionHistory3);
        System.out.println("Linked Accounts: " + linkedAccounts3);
        System.out.println("Notifications: " + notifications3);
        System.out.println("Available Balance: " + availableBalance3);
        System.out.println("Is Closed: " + isClosed3);
    }
}
