import java.util.Date;

public class BankAccount implements Comparable<BankAccount>{
    private String accountNumber;
    private double balance;
    private Customer owner;
    private Date creationTime;

    public BankAccount(){

    }

    public BankAccount(String accountNumber, double balance, Customer owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
        this.creationTime = new Date(); // Set the creation time to the current time
    }

    // Getters and setters for account number, balance, owner, and creation time

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " from account " + accountNumber + " successful.");
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal.");
        }
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " into account " + accountNumber + " successful.");
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void transfer(BankAccount destinationAccount, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
            return;
        }
        if (this.balance < amount) {
            System.out.println("Insufficient funds for transfer.");
            return;
        }

        this.withdraw(amount);
        destinationAccount.deposit(amount);

        // Print transfer details
        System.out.println("Transfer of $" + amount + " from account " + this.accountNumber +
                " to account " + destinationAccount.getAccountNumber() + " completed.");
    }

    @Override
    public int compareTo(BankAccount o) {
        return 0;
    }

    public String toString() {
        return "Account Number: " + accountNumber + ", Balance: $" + balance + ", Customer:" + owner;
    }
}



