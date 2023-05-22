package com.company;
import com.company.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int accountNumber;
    private double balance;
    private List<Transaction> transactionHistory;
    private List<Account> linkedAccounts;
    private List<Notification> notifications;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
        this.linkedAccounts = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public List<Account> getLinkedAccounts() {
        return linkedAccounts;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void addLinkedAccount(Account account) {
        linkedAccounts.add(account);
    }

    public void removeLinkedAccount(Account account) {
        linkedAccounts.remove(account);
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction(amount, "Deposit"));
        notifyUser("Deposit of " + amount + " has been credited.");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -=amount;
            transactionHistory.add(new Transaction(amount, "Withdrawal"));
            notifyUser("Withdrawal of " + amount + " has been debited.");
        } else {
            notifyUser("Error: Insufficient funds.");
        }
    }

    public void transfer(double amount, Account recipient) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction(amount, "Transfer to account " + recipient.getAccountNumber()));
            recipient.receiveTransfer(amount, this);
            notifyUser("Transfer of " + amount + " to account " + recipient.getAccountNumber() + " has been debited.");
        } else {
            notifyUser("Error: Insufficient funds.");
        }
    }

    private void receiveTransfer(double amount, Account sender) {
        balance += amount;
        transactionHistory.add(new Transaction(amount, "Transfer from account " + sender.getAccountNumber()));
        notifyUser("Transfer of " + amount + " from account " + sender.getAccountNumber() + " has been credited.");
    }

    public void payBill(double amount, String billName) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction(amount, "Bill payment for " + billName));
            notifyUser("Bill payment of " + amount + " for " + billName + " has been debited.");
        } else {
            notifyUser("Error: Insufficient funds.");
        }
    }

    public void notifyUser(String message) {
        notifications.add(new Notification(message));
    }
    private double overdraftLimit;
    public void setOverdraftLimit(double limit) {
        overdraftLimit = limit;
    }
    private double availableBalance;
    public double getAvailableBalance() {
        double pendingTransactions = 0.0;
        // calculate the total amount of pending transactions or holds
        // and store it in the pendingTransactions variable
        availableBalance = balance - pendingTransactions;
        if (availableBalance < 0 && Math.abs(availableBalance) <= overdraftLimit) {
            // if the available balance is negative but within the overdraft limit,
            // return the negative available balance
            return availableBalance;
        } else if (availableBalance < 0 && Math.abs(availableBalance) > overdraftLimit) {
            // if the available balance is negative and exceeds the overdraft limit,
            // return 0.0 (i.e. the user cannot withdraw any more funds)
            return 0.0;
        } else {
            // if the available balance is positive or zero, return it
            return availableBalance;
        }
    }
    private boolean isClosed;
    public void closeAccount() {
        // perform any necessary tasks to close the account (e.g. transfer remainingbalance, issue a check, etc.)
        isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }
}
