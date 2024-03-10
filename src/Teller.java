import java.util.Date;

public class Teller {
    public void deposit(BankAccount account, double amount) {
        // Perform deposit operation
        account.deposit(amount);

        // Record transaction
        Transaction transaction = new Transaction(Transaction.TransactionType.DEPOSIT, account, amount);
        transaction.recordTransaction();
    }

    public void withdraw(BankAccount account, double amount) {
        // Perform withdrawal operation
        account.withdraw(amount);

        // Record transaction
        Transaction transaction = new Transaction(Transaction.TransactionType.WITHDRAWAL, account, amount);
        transaction.recordTransaction();
    }

    public void transfer(BankAccount sourceAccount, BankAccount destinationAccount, double amount) {
        // Perform transfer operation
        sourceAccount.withdraw(amount);
        destinationAccount.deposit(amount);

        // Record transaction for source account
        Transaction transaction1 = new Transaction(Transaction.TransactionType.TRANSFER_OUT, sourceAccount, amount);
        transaction1.recordTransaction();

        // Record transaction for destination account
        Transaction transaction2 = new Transaction(Transaction.TransactionType.TRANSFER_IN, destinationAccount, amount);
        transaction2.recordTransaction();
    }
}



