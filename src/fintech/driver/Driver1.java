package fintech.driver;

import fintech.model.Account;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 12S23001 - Kevin Gultom
 * @author 12S23010 - Tiffani Butar-Butar
 */

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] parts = input.split("#");

            if (parts[0].equals("create-account")) {
                String owner = parts[1];
                String accountName = parts[2];
                accounts.put(accountName, new Account(owner, accountName));
                System.out.println(accountName + "|" + owner + "|0.0");
            } else if (parts[0].equals("create-transaction")) {
                String accountName = parts[1];
                double amount = Double.parseDouble(parts[2]);
                String postedAt = parts[3];
                String note = parts[4];
                
                if (accounts.containsKey(accountName)) {
                    Account account = accounts.get(accountName);
                    if (account.getBalance() + amount >= 0) { 
                        account.addTransaction(amount, postedAt, note);
                    }
                }
            } else if (parts[0].equals("show-account")) {
                String accountName = parts[1];
                if (accounts.containsKey(accountName)) {
                    accounts.get(accountName).showAccount();
                }
            }
        }
        scanner.close();
    }
}
