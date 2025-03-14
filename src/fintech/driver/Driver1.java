package fintech.driver;

/**
 * @author 12S23001 - Kevin Gultom
 * @author 12S23010 - Tiffani Butar-Butar
 */
import fintech.model.Account;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

    while (scanner.hasNextLine()) {
        String input = scanner.nextLine();
        String[] parts = input.split("#");
    if (parts[0].equals("create-account")) {
        String owner = parts[1];
        String accountname = parts[2];
             accounts.put(accountname, new Account(owner, accountname));
              
        System.out.println(accountname + "|" + owner + "|0.0");
    } else if (parts[0].equals("create-transaction")) {
        String accountname = parts[1];
        double amount = Double.parseDouble(parts[2]);
        String posted_at = parts[3];
        String note = parts[4];
    if (accounts.containsKey(accountname)) {
        accounts.get(accountname).addTransaction(amount, posted_at, note);
}
        } else if (parts[0].equals("show-account")) {
        String accountname = parts[1];
        if (accounts.containsKey(accountname)) {
        accounts.get(accountname).showAccount();
        }
    }
}
     scanner.close();
}
}