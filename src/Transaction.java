import java.util.Date;
public class Transaction {
    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL,
        TRANSFER_IN,
        TRANSFER_OUT
    }
    private TransactionType type;
    private BankAccount account;
    private double amount;
    private Date timestamp;

    public Transaction(TransactionType type, BankAccount account, double amount) {
        this.type = type;
        this.account = account;
        this.amount = amount;
        this.timestamp = new Date(); // Current timestamp
    }

    public void recordTransaction() {
        // Logic to record transaction details
        // For example, store in a database, log, etc.
        System.out.println("Transaction recorded: " + this);
        // You can also send email notifications here
    }

    @Override
    public String toString() {
        return "Transaction: Type=" + type +
                ", Account=" + account.getAccountNumber() +
                ", Amount=" + amount +
                ", Timestamp=" + timestamp;
    }
}

