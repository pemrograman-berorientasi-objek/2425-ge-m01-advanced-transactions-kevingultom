package fintech.model;

import java.util.*;

/**
 * @author 12S23001 - Kevin Gultom
 * @author 12S23010 - Tiffani Butar-Butar
 */


public class Account {
    private String accountname;
    private String owner;
    private double balance;
    private List<Transaction> transactions;

    public Account(String owner, String accountname) {
        this.owner = owner;
        this.accountname = accountname;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountname() {
        return accountname;
    }
    public double getBalance() {
        return balance;
    }
    public void addTransaction(double amount, String posted_at, String note) {
        if (balance + amount >= 0) { 
            Transaction transaction = new Transaction(accountname, amount, posted_at, note);
            transactions.add(transaction);
            balance += amount;
        }

    }public void showAccount() {
        System.out.println(accountname + "|" + owner + "|" + balance);
        for (Transaction n : transactions) 


        {
            System.out.println(n);
        }
    }
}