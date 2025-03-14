package fintech.model;

/**
 * @author 12S23001 - Kevin Gultom
 * @author 12S23010 - Tiffani Butar-Butar
 */
  class Transaction {
      private static int counter;
      private int id;
      private String accountId;
      private double amount;
      private String posted_at;
      private String note;
  
      public Transaction(String accountId, double amount, String posted_at, String note) {
          this.id = ++counter;
          this.accountId = accountId;
          this.amount = amount;
          this.posted_at = posted_at;
          this.note = note;
      }

      public double getAmount() {
          return amount;
      }
  
      public String toString() {
          return id + "|" + accountId + "|" + amount + "|" + posted_at + "|" + note;
      }
  }